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

import com.amigos.dto.CandidateProfiles;
import com.amigos.service.CandidateProfilesService;

@RestController
public class CandidateProfilesController {

	@Autowired
	private CandidateProfilesService candidateProfilesService;

	@RequestMapping(value = "/candidateProfiles", method = RequestMethod.GET)
	public ResponseEntity<List<CandidateProfiles>> getCandidateProfiless() {
		List<CandidateProfiles> candidateProfiles = candidateProfilesService.getAll();
		if (candidateProfiles.isEmpty()) {
			return new ResponseEntity<List<CandidateProfiles>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<CandidateProfiles>>(candidateProfiles, HttpStatus.OK);
	}

	@RequestMapping(value = "/candidateProfiles", method = RequestMethod.POST)
	public ResponseEntity<Void> saveCandidateProfiles(@RequestBody CandidateProfiles candidateProfiles,
			UriComponentsBuilder ucBuilder) {
		if (candidateProfiles == null) {
			throw new RuntimeException("CandidateProfiles FirstName  are required fields");
		}
		Long id = candidateProfilesService.save(candidateProfiles);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/candidateProfiles/{id}").buildAndExpand(id).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/candidateProfiles", method = RequestMethod.PUT)
	public ResponseEntity<CandidateProfiles> updateCandidateProfiles(@RequestBody CandidateProfiles candidateProfiles) {
		if (candidateProfiles == null || candidateProfiles.getCandidateId() <= 0) {
			throw new RuntimeException("CandidateProfiles FirstName, Id  are required fields");
		}
		CandidateProfiles updatedCandidateProfiles = candidateProfilesService.update(candidateProfiles);
		if (updatedCandidateProfiles == null) {
			return new ResponseEntity<CandidateProfiles>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<CandidateProfiles>(updatedCandidateProfiles, HttpStatus.OK);
	}

	@RequestMapping(value = "/candidateProfiles/{id}", method = RequestMethod.GET)
	public ResponseEntity<CandidateProfiles> getCandidateProfilesByid(@PathVariable Long id) {
		CandidateProfiles candidateProfiles = candidateProfilesService.getCandidateProfilesById(id);
		if (candidateProfiles == null) {
			return new ResponseEntity<CandidateProfiles>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<CandidateProfiles>(candidateProfiles, HttpStatus.OK);
	}

	@RequestMapping(value = "/candidateProfiles/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteCandidateProfilesByid(@PathVariable Long id) {
		CandidateProfiles existingCandidateProfiles = candidateProfilesService.getCandidateProfilesById(id);
		if (existingCandidateProfiles == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		candidateProfilesService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
