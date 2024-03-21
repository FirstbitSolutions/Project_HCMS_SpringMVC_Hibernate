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

import com.amigos.dto.LeaveTypes;
import com.amigos.service.LeaveTypesService;

@RestController
public class LeaveTypesController {

	@Autowired
	private LeaveTypesService leaveTypesService;

	@RequestMapping(value = "/leaveTypes", method = RequestMethod.GET)
	public ResponseEntity<List<LeaveTypes>> getLeaveTypess() {
		List<LeaveTypes> leaveTypes = leaveTypesService.getAll();
		if (leaveTypes.isEmpty()) {
			return new ResponseEntity<List<LeaveTypes>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<LeaveTypes>>(leaveTypes, HttpStatus.OK);
	}

	@RequestMapping(value = "/leaveTypes", method = RequestMethod.POST)
	public ResponseEntity<Void> saveLeaveTypes(@RequestBody LeaveTypes leaveTypes, UriComponentsBuilder ucBuilder) {
		if (leaveTypes == null) {
			throw new RuntimeException("LeaveTypes  are required fields");
		}
		Long id = leaveTypesService.save(leaveTypes);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/leaveTypes/{id}").buildAndExpand(id).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/leaveTypes", method = RequestMethod.PUT)
	public ResponseEntity<LeaveTypes> updateLeaveTypes(@RequestBody LeaveTypes leaveTypes) {
		if (leaveTypes == null || leaveTypes.getLeaveTypeId() <= 0) {
			throw new RuntimeException("LeaveTypes  are required fields");
		}
		LeaveTypes updatedLeaveTypes = leaveTypesService.update(leaveTypes);
		if (updatedLeaveTypes == null) {
			return new ResponseEntity<LeaveTypes>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<LeaveTypes>(updatedLeaveTypes, HttpStatus.OK);
	}

	@RequestMapping(value = "/leaveTypes/{id}", method = RequestMethod.GET)
	public ResponseEntity<LeaveTypes> getLeaveTypesByid(@PathVariable Long id) {
		LeaveTypes leaveTypes = leaveTypesService.getLeaveTypesById(id);
		if (leaveTypes == null) {
			return new ResponseEntity<LeaveTypes>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<LeaveTypes>(leaveTypes, HttpStatus.OK);
	}

	@RequestMapping(value = "/leaveTypes/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteLeaveTypesByid(@PathVariable Long id) {
		LeaveTypes existingLeaveTypes = leaveTypesService.getLeaveTypesById(id);
		if (existingLeaveTypes == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		leaveTypesService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
