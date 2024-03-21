package com.amigos.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.amigos.dto.LeaveRequests;
import com.amigos.service.LeaveRequestsService;

@RestController
public class LeaveRequestsController {

	@Autowired
	private LeaveRequestsService leaveRequestsService;

	@RequestMapping(value = "/leaveRequests", method = RequestMethod.GET)
	public ResponseEntity<List<LeaveRequests>> getLeaveRequestss() {
		List<LeaveRequests> leaveRequests = leaveRequestsService.getAll();
		if (leaveRequests.isEmpty()) {
			return new ResponseEntity<List<LeaveRequests>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<LeaveRequests>>(leaveRequests, HttpStatus.OK);
	}

	@RequestMapping(value = "/leaveRequests", method = RequestMethod.POST)
	public ResponseEntity<Void> saveLeaveRequests(@RequestBody LeaveRequests leaveRequests,
			UriComponentsBuilder ucBuilder) {
		if (leaveRequests == null) {
			throw new RuntimeException("LeaveRequests  are required fields");
		}
		Long id = leaveRequestsService.save(leaveRequests);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/leaveRequests/{id}").buildAndExpand(id).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/leaveRequests", method = RequestMethod.PUT)
	public ResponseEntity<LeaveRequests> updateLeaveRequests(@RequestBody LeaveRequests leaveRequests) {
		if (leaveRequests == null || leaveRequests.getLeaveRequestId() <= 0) {
			throw new RuntimeException("LeaveRequests  are required fields");
		}
		LeaveRequests updatedLeaveRequests = leaveRequestsService
				.getLeaveRequestsById(Long.valueOf(leaveRequests.getLeaveRequestId()));
		if (updatedLeaveRequests == null) {
			return new ResponseEntity<LeaveRequests>(HttpStatus.NOT_FOUND);
		}
		leaveRequestsService.update(leaveRequests);
		return new ResponseEntity<LeaveRequests>(updatedLeaveRequests, HttpStatus.OK);
	}

	@RequestMapping(value = "/leaveRequests/{id}", method = RequestMethod.GET)
	public ResponseEntity<LeaveRequests> getLeaveRequestsByid(@PathVariable Long id) {
		LeaveRequests leaveRequests = leaveRequestsService.getLeaveRequestsById(id);
		if (leaveRequests == null) {
			return new ResponseEntity<LeaveRequests>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<LeaveRequests>(leaveRequests, HttpStatus.OK);
	}

	@RequestMapping(value = "/leaveRequests/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteLeaveRequestsByid(@PathVariable Long id) {
		LeaveRequests existingLeaveRequests = leaveRequestsService.getLeaveRequestsById(id);
		if (existingLeaveRequests == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		leaveRequestsService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
