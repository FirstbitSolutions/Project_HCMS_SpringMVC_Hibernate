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

import com.amigos.dto.TrainingSchedules;
import com.amigos.service.TrainingSchedulesService;

@RestController
public class TrainingSchedulesController {

	@Autowired
	private TrainingSchedulesService trainingSchedulesService;

	@RequestMapping(value = "/trainingSchedules", method = RequestMethod.GET)
	public ResponseEntity<List<TrainingSchedules>> getTrainingScheduless() {
		List<TrainingSchedules> trainingSchedules = trainingSchedulesService.getAll();
		if (trainingSchedules.isEmpty()) {
			return new ResponseEntity<List<TrainingSchedules>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<TrainingSchedules>>(trainingSchedules, HttpStatus.OK);
	}

	@RequestMapping(value = "/trainingSchedules", method = RequestMethod.POST)
	public ResponseEntity<Void> saveTrainingSchedules(@RequestBody TrainingSchedules trainingSchedules,
			UriComponentsBuilder ucBuilder) {
		if (trainingSchedules == null) {
			throw new RuntimeException("TrainingSchedules  are required fields");
		}
		Long id = trainingSchedulesService.save(trainingSchedules);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/trainingSchedules/{id}").buildAndExpand(id).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/trainingSchedules", method = RequestMethod.PUT)
	public ResponseEntity<TrainingSchedules> updateTrainingSchedules(@RequestBody TrainingSchedules trainingSchedules) {
		if (trainingSchedules == null || trainingSchedules.getScheduleId() <= 0) {
			throw new RuntimeException("TrainingSchedules  are required fields");
		}
		TrainingSchedules updatedTrainingSchedules = trainingSchedulesService.update(trainingSchedules);
		if (updatedTrainingSchedules == null) {
			return new ResponseEntity<TrainingSchedules>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<TrainingSchedules>(updatedTrainingSchedules, HttpStatus.OK);
	}

	@RequestMapping(value = "/trainingSchedules/{id}", method = RequestMethod.GET)
	public ResponseEntity<TrainingSchedules> getTrainingSchedulesByid(@PathVariable Long id) {
		TrainingSchedules trainingSchedules = trainingSchedulesService.getTrainingSchedulesById(id);
		if (trainingSchedules == null) {
			return new ResponseEntity<TrainingSchedules>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<TrainingSchedules>(trainingSchedules, HttpStatus.OK);
	}

	@RequestMapping(value = "/trainingSchedules/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteTrainingSchedulesByid(@PathVariable Long id) {
		TrainingSchedules existingTrainingSchedules = trainingSchedulesService.getTrainingSchedulesById(id);
		if (existingTrainingSchedules == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		trainingSchedulesService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
