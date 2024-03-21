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

import com.amigos.dto.TrainingFeedback;
import com.amigos.service.TrainingFeedbackService;

@RestController
public class TrainingFeedbackController {

	@Autowired
	private TrainingFeedbackService trainingFeedbackService;

	@RequestMapping(value = "/trainingFeedback", method = RequestMethod.GET)
	public ResponseEntity<List<TrainingFeedback>> getTrainingFeedbacks() {
		List<TrainingFeedback> trainingFeedback = trainingFeedbackService.getAll();
		if (trainingFeedback.isEmpty()) {
			return new ResponseEntity<List<TrainingFeedback>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<TrainingFeedback>>(trainingFeedback, HttpStatus.OK);
	}

	@RequestMapping(value = "/trainingFeedback", method = RequestMethod.POST)
	public ResponseEntity<Void> saveTrainingFeedback(@RequestBody TrainingFeedback trainingFeedback,
			UriComponentsBuilder ucBuilder) {
		if (trainingFeedback == null) {
			throw new RuntimeException("TrainingFeedback  are required fields");
		}
		Long id = trainingFeedbackService.save(trainingFeedback);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/trainingFeedback/{id}").buildAndExpand(id).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/trainingFeedback", method = RequestMethod.PUT)
	public ResponseEntity<TrainingFeedback> updateTrainingFeedback(@RequestBody TrainingFeedback trainingFeedback) {
		if (trainingFeedback == null || trainingFeedback.getFeedbackId() <= 0) {
			throw new RuntimeException("TrainingFeedback  are required fields");
		}
		TrainingFeedback updatedTrainingFeedback = trainingFeedbackService.update(trainingFeedback);
		if (updatedTrainingFeedback == null) {
			return new ResponseEntity<TrainingFeedback>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<TrainingFeedback>(updatedTrainingFeedback, HttpStatus.OK);
	}

	@RequestMapping(value = "/trainingFeedback/{id}", method = RequestMethod.GET)
	public ResponseEntity<TrainingFeedback> getTrainingFeedbackByid(@PathVariable Long id) {
		TrainingFeedback trainingFeedback = trainingFeedbackService.getTrainingFeedbackById(id);
		if (trainingFeedback == null) {
			return new ResponseEntity<TrainingFeedback>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<TrainingFeedback>(trainingFeedback, HttpStatus.OK);
	}

	@RequestMapping(value = "/trainingFeedback/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteTrainingFeedbackByid(@PathVariable Long id) {
		TrainingFeedback existingTrainingFeedback = trainingFeedbackService.getTrainingFeedbackById(id);
		if (existingTrainingFeedback == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		trainingFeedbackService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
