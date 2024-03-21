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

import com.amigos.dto.ExternalTrainers;
import com.amigos.service.ExternalTrainersService;

@RestController
public class ExternalTrainersController {

	@Autowired
	private ExternalTrainersService externalTrainersService;

	@RequestMapping(value = "/externalTrainers", method = RequestMethod.GET)
	public ResponseEntity<List<ExternalTrainers>> getExternalTrainerss() {
		List<ExternalTrainers> externalTrainers = externalTrainersService.getAll();
		if (externalTrainers.isEmpty()) {
			return new ResponseEntity<List<ExternalTrainers>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<ExternalTrainers>>(externalTrainers, HttpStatus.OK);
	}

	@RequestMapping(value = "/externalTrainers", method = RequestMethod.POST)
	public ResponseEntity<Void> saveExternalTrainers(@RequestBody ExternalTrainers externalTrainers,
			UriComponentsBuilder ucBuilder) {
		if (externalTrainers == null) {
			throw new RuntimeException("ExternalTrainers  are required fields");
		}
		Long id = externalTrainersService.save(externalTrainers);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/externalTrainers/{id}").buildAndExpand(id).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/externalTrainers", method = RequestMethod.PUT)
	public ResponseEntity<ExternalTrainers> updateExternalTrainers(@RequestBody ExternalTrainers externalTrainers) {
		if (externalTrainers == null || externalTrainers.getTrainerId() <= 0) {
			throw new RuntimeException("ExternalTrainers  are required fields");
		}
		ExternalTrainers updatedExternalTrainers = externalTrainersService.update(externalTrainers);
		if (updatedExternalTrainers == null) {
			return new ResponseEntity<ExternalTrainers>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ExternalTrainers>(updatedExternalTrainers,HttpStatus.OK);
	}

	@RequestMapping(value = "/externalTrainers/{id}", method = RequestMethod.GET)
	public ResponseEntity<ExternalTrainers> getExternalTrainersByid(@PathVariable Long id) {
		ExternalTrainers externalTrainers = externalTrainersService.getExternalTrainersById(id);
		if (externalTrainers == null) {
			return new ResponseEntity<ExternalTrainers>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<ExternalTrainers>(externalTrainers, HttpStatus.OK);
	}

	@RequestMapping(value = "/externalTrainers/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteExternalTrainersByid(@PathVariable Long id) {
		ExternalTrainers existingExternalTrainers = externalTrainersService.getExternalTrainersById(id);
		if (existingExternalTrainers == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		externalTrainersService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
