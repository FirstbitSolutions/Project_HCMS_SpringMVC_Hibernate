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

import com.amigos.dto.AppraisalForms;
import com.amigos.service.AppraisalFormsService;

@RestController
public class AppraisalFormsController {

	@Autowired
	private AppraisalFormsService appraisalFormsService;

	@RequestMapping(value = "/appraisalForms", method = RequestMethod.GET)
	public ResponseEntity<List<AppraisalForms>> getAppraisalFormss() {
		List<AppraisalForms> appraisalForms = appraisalFormsService.getAll();
		if (appraisalForms.isEmpty()) {
			return new ResponseEntity<List<AppraisalForms>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<AppraisalForms>>(appraisalForms, HttpStatus.OK);
	}

	@RequestMapping(value = "/appraisalForms", method = RequestMethod.POST)
	public ResponseEntity<Void> saveAppraisalForms(@RequestBody AppraisalForms appraisalForms,
			UriComponentsBuilder ucBuilder) {
		if (appraisalForms == null) {
			throw new RuntimeException("AppraisalForms FirstName  are required fields");
		}
		Long id = appraisalFormsService.save(appraisalForms);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/appraisalForms/{id}").buildAndExpand(id).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/appraisalForms", method = RequestMethod.PUT)
	public ResponseEntity<AppraisalForms> updateAppraisalForms(@RequestBody AppraisalForms appraisalForms) {
		if (appraisalForms == null || appraisalForms.getFormId() <= 0) {
			throw new RuntimeException("AppraisalForms Id  are required fields");
		}
		AppraisalForms updatedAppraisalForms = appraisalFormsService.update(appraisalForms);
		if (updatedAppraisalForms == null) {
			return new ResponseEntity<AppraisalForms>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<AppraisalForms>(updatedAppraisalForms, HttpStatus.OK);
	}

	@RequestMapping(value = "/appraisalForms/{id}", method = RequestMethod.GET)
	public ResponseEntity<AppraisalForms> getAppraisalFormsByid(@PathVariable Long id) {
		AppraisalForms appraisalForms = appraisalFormsService.getAppraisalFormsById(id);
		if (appraisalForms == null) {
			return new ResponseEntity<AppraisalForms>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<AppraisalForms>(appraisalForms, HttpStatus.OK);
	}

	@RequestMapping(value = "/appraisalForms/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteAppraisalFormsByid(@PathVariable Long id) {
		AppraisalForms existingAppraisalForms = appraisalFormsService.getAppraisalFormsById(id);
		if (existingAppraisalForms == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		appraisalFormsService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}