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

import com.amigos.dto.ApplicationStatus;
import com.amigos.service.ApplicationStatusService;

@RestController
public class ApplicationStatusController {

	@Autowired
	private ApplicationStatusService applicationStatusService;

	@RequestMapping(value = "/applicationStatus", method = RequestMethod.GET)
	public ResponseEntity<List<ApplicationStatus>> getApplicationStatuss() {
		List<ApplicationStatus> applicationStatuss = applicationStatusService.getAll();
		if (applicationStatuss.isEmpty()) {
			return new ResponseEntity<List<ApplicationStatus>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<ApplicationStatus>>(applicationStatuss, HttpStatus.OK);
	}

	@RequestMapping(value = "/applicationStatus", method = RequestMethod.POST)
	public ResponseEntity<Void> saveApplicationStatus(@RequestBody ApplicationStatus applicationStatus,
			UriComponentsBuilder ucBuilder) {
		if (applicationStatus == null) {
			throw new RuntimeException("ApplicationStatus  are required fields");
		}
		Long id = applicationStatusService.save(applicationStatus);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/applicationStatus/{id}").buildAndExpand(id).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/applicationStatus", method = RequestMethod.PUT)
	public ResponseEntity<ApplicationStatus> updateApplicationStatus(@RequestBody ApplicationStatus applicationStatus) {
		if (applicationStatus == null || applicationStatus.getApplicationId() <= 0) {
			throw new RuntimeException("ApplicationStatus , Id  are required fields");
		}
		ApplicationStatus updatedApplicationStatus = applicationStatusService.update(applicationStatus);
		if (updatedApplicationStatus == null) {
			return new ResponseEntity<ApplicationStatus>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ApplicationStatus>(updatedApplicationStatus, HttpStatus.OK);
	}

	@RequestMapping(value = "/applicationStatus/{id}", method = RequestMethod.GET)
	public ResponseEntity<ApplicationStatus> getApplicationStatusByid(@PathVariable Long id) {
		ApplicationStatus applicationStatus = applicationStatusService.getApplicationStatusById(id);
		if (applicationStatus == null) {
			return new ResponseEntity<ApplicationStatus>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ApplicationStatus>(applicationStatus, HttpStatus.OK);
	}

	@RequestMapping(value = "/applicationStatus/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteApplicationStatusByid(@PathVariable Long id) {
		ApplicationStatus existingApplicationStatus = applicationStatusService.getApplicationStatusById(id);
		if (existingApplicationStatus == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		applicationStatusService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}