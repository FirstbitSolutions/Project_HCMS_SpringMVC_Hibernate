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

import com.amigos.dto.TrainingModules;
import com.amigos.service.TrainingModulesService;

@RestController
public class TrainingModulesController {

	@Autowired
	private TrainingModulesService trainingModulesService;

	@RequestMapping(value = "/trainingModules", method = RequestMethod.GET)
	public ResponseEntity<List<TrainingModules>> getTrainingModuless() {
		List<TrainingModules> trainingModules = trainingModulesService.getAll();
		if (trainingModules.isEmpty()) {
			return new ResponseEntity<List<TrainingModules>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<TrainingModules>>(trainingModules, HttpStatus.OK);
	}

	@RequestMapping(value = "/trainingModules", method = RequestMethod.POST)
	public ResponseEntity<Void> saveTrainingModules(@RequestBody TrainingModules trainingModules,
			UriComponentsBuilder ucBuilder) {
		if (trainingModules == null) {
			throw new RuntimeException("TrainingModules  are required fields");
		}
		Long id = trainingModulesService.save(trainingModules);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/trainingModules/{id}").buildAndExpand(id).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/trainingModules", method = RequestMethod.PUT)
	public ResponseEntity<TrainingModules> updateTrainingModules(@RequestBody TrainingModules trainingModules) {
		if (trainingModules == null || trainingModules.getModuleId() <= 0) {
			throw new RuntimeException("TrainingModules  are required fields");
		}
		TrainingModules updatedTrainingModules = trainingModulesService.update(trainingModules);
		if (updatedTrainingModules == null) {
			return new ResponseEntity<TrainingModules>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<TrainingModules>(HttpStatus.OK);
	}

	@RequestMapping(value = "/trainingModules/{id}", method = RequestMethod.GET)
	public ResponseEntity<TrainingModules> getTrainingModulesByid(@PathVariable Long id) {
		TrainingModules trainingModules = trainingModulesService.getTrainingModulesById(id);
		if (trainingModules == null) {
			return new ResponseEntity<TrainingModules>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<TrainingModules>(trainingModules, HttpStatus.OK);
	}

	@RequestMapping(value = "/trainingModules/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteTrainingModulesByid(@PathVariable Long id) {
		TrainingModules existingTrainingModules = trainingModulesService.getTrainingModulesById(id);
		if (existingTrainingModules == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		trainingModulesService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
