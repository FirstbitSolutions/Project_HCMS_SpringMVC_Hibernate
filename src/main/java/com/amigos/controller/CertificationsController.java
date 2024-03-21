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

import com.amigos.dto.Certifications;
import com.amigos.service.CertificationsService;

@RestController
public class CertificationsController {

	@Autowired
	private CertificationsService certificationsService;

	@RequestMapping(value = "/certifications", method = RequestMethod.GET)
	public ResponseEntity<List<Certifications>> getCertificationss() {
		List<Certifications> certifications = certificationsService.getAll();
		if (certifications.isEmpty()) {
			return new ResponseEntity<List<Certifications>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Certifications>>(certifications, HttpStatus.OK);
	}

	@RequestMapping(value = "/certifications", method = RequestMethod.POST)
	public ResponseEntity<Void> saveCertifications(@RequestBody Certifications certifications,
			UriComponentsBuilder ucBuilder) {
		if (certifications == null) {
			throw new RuntimeException("Certifications  are required fields");
		}
		Long id = certificationsService.save(certifications);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/certifications/{id}").buildAndExpand(id).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/certifications", method = RequestMethod.PUT)
	public ResponseEntity<Certifications> updateCertifications(@RequestBody Certifications certifications) {
		if (certifications == null || certifications.getCertificationId() <= 0) {
			throw new RuntimeException("Certifications id  are required fields");
		}
		Certifications updatedCertifications = certificationsService.update(certifications);
		if (updatedCertifications == null) {
			return new ResponseEntity<Certifications>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Certifications>(updatedCertifications, HttpStatus.OK);
	}

	@RequestMapping(value = "/certifications/{id}", method = RequestMethod.GET)
	public ResponseEntity<Certifications> getCertificationsByid(@PathVariable Long id) {
		Certifications certifications = certificationsService.getCertificationsById(id);
		if (certifications == null) {
			return new ResponseEntity<Certifications>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Certifications>(certifications, HttpStatus.OK);
	}

	@RequestMapping(value = "/certifications/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteCertificationsByid(@PathVariable Long id) {
		Certifications existingCertifications = certificationsService.getCertificationsById(id);
		if (existingCertifications == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		certificationsService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
