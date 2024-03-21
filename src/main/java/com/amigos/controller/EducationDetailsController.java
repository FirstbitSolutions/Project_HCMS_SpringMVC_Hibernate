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

import com.amigos.dto.EducationDetails;
import com.amigos.service.EducationDetailsService;

@RestController
public class EducationDetailsController {

	@Autowired
	private EducationDetailsService educationDetailsService;

	@RequestMapping(value = "/educationDetails", method = RequestMethod.GET)
	public ResponseEntity<List<EducationDetails>> getEducationDetailss() {
		List<EducationDetails> educationDetails = educationDetailsService.getAll();
		if (educationDetails.isEmpty()) {
			return new ResponseEntity<List<EducationDetails>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<EducationDetails>>(educationDetails, HttpStatus.OK);
	}

	@RequestMapping(value = "/educationDetails", method = RequestMethod.POST)
	public ResponseEntity<Void> saveEducationDetails(@RequestBody EducationDetails educationDetails,
			UriComponentsBuilder ucBuilder) {
		if (educationDetails == null) {
			throw new RuntimeException("EducationDetails  are required fields");
		}
		Long id = educationDetailsService.save(educationDetails);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/educationDetails/{id}").buildAndExpand(id).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/educationDetails", method = RequestMethod.PUT)
	public ResponseEntity<EducationDetails> updateEducationDetails(@RequestBody EducationDetails educationDetails) {
		if (educationDetails == null || educationDetails.getEducationId() <= 0) {
			throw new RuntimeException("EducationDetails  are required fields");
		}
		EducationDetails updatedEducationDetails = educationDetailsService.update(educationDetails);
		if (updatedEducationDetails == null) {
			return new ResponseEntity<EducationDetails>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<EducationDetails>(updatedEducationDetails, HttpStatus.OK);
	}

	@RequestMapping(value = "/educationDetails/{id}", method = RequestMethod.GET)
	public ResponseEntity<EducationDetails> getEducationDetailsByid(@PathVariable Long id) {
		EducationDetails educationDetails = educationDetailsService.getEducationDetailsById(id);
		if (educationDetails == null) {
			return new ResponseEntity<EducationDetails>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<EducationDetails>(educationDetails, HttpStatus.OK);
	}

	@RequestMapping(value = "/educationDetails/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteEducationDetailsByid(@PathVariable Long id) {
		EducationDetails existingEducationDetails = educationDetailsService.getEducationDetailsById(id);
		if (existingEducationDetails == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		educationDetailsService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
