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

import com.amigos.dto.LeaveApprovals;
import com.amigos.service.LeaveApprovalsService;

@RestController
public class LeaveApprovalsController {

	@Autowired
	private LeaveApprovalsService leaveApprovalsService;

	@RequestMapping(value = "/leaveApprovals", method = RequestMethod.GET)
	public ResponseEntity<List<LeaveApprovals>> getLeaveApprovalss() {
		List<LeaveApprovals> leaveApprovals = leaveApprovalsService.getAll();
		if (leaveApprovals.isEmpty()) {
			return new ResponseEntity<List<LeaveApprovals>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<LeaveApprovals>>(leaveApprovals, HttpStatus.OK);
	}

	@RequestMapping(value = "/leaveApprovals", method = RequestMethod.POST)
	public ResponseEntity<Void> saveLeaveApprovals(@RequestBody LeaveApprovals leaveApprovals,
			UriComponentsBuilder ucBuilder) {
		if (leaveApprovals == null) {
			throw new RuntimeException("LeaveApprovals  are required fields");
		}
		Long id = leaveApprovalsService.save(leaveApprovals);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/leaveApprovals/{id}").buildAndExpand(id).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/leaveApprovals", method = RequestMethod.PUT)
	public ResponseEntity<LeaveApprovals> updateLeaveApprovals(@RequestBody LeaveApprovals leaveApprovals) {
		if (leaveApprovals == null || leaveApprovals.getApprovalId() <= 0) {
			throw new RuntimeException("LeaveApprovals  are required fields");
		}
		LeaveApprovals updatedLeaveApprovals = leaveApprovalsService.update(leaveApprovals);
		if (updatedLeaveApprovals == null) {
			return new ResponseEntity<LeaveApprovals>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<LeaveApprovals>(updatedLeaveApprovals, HttpStatus.OK);
	}

	@RequestMapping(value = "/leaveApprovals/{id}", method = RequestMethod.GET)
	public ResponseEntity<LeaveApprovals> getLeaveApprovalsByid(@PathVariable Long id) {
		LeaveApprovals leaveApprovals = leaveApprovalsService.getLeaveApprovalsById(id);
		if (leaveApprovals == null) {
			return new ResponseEntity<LeaveApprovals>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<LeaveApprovals>(leaveApprovals, HttpStatus.OK);
	}

	@RequestMapping(value = "/leaveApprovals/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteLeaveApprovalsByid(@PathVariable Long id) {
		LeaveApprovals existingLeaveApprovals = leaveApprovalsService.getLeaveApprovalsById(id);
		if (existingLeaveApprovals == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		leaveApprovalsService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
