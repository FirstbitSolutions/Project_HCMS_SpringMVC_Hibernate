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

import com.amigos.dto.Trainers;
import com.amigos.service.TrainersService;

@RestController
public class TrainersController {

	@Autowired
	private TrainersService trainersService;

	@RequestMapping(value = "/trainers", method = RequestMethod.GET)
	public ResponseEntity<List<Trainers>> getTrainerss() {
		List<Trainers> trainers = trainersService.getAll();
		if (trainers.isEmpty()) {
			return new ResponseEntity<List<Trainers>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Trainers>>(trainers, HttpStatus.OK);
	}

	@RequestMapping(value = "/trainers", method = RequestMethod.POST)
	public ResponseEntity<Void> saveTrainers(@RequestBody Trainers trainers, UriComponentsBuilder ucBuilder) {
		if (trainers == null) {
			throw new RuntimeException("Trainers  are required fields");
		}
		Long id = trainersService.save(trainers);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/trainers/{id}").buildAndExpand(id).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/trainers", method = RequestMethod.PUT)
	public ResponseEntity<Trainers> updateTrainers(@RequestBody Trainers trainers) {
		if (trainers == null || trainers.getTrainerId() <= 0) {
			throw new RuntimeException("Trainers  are required fields");
		}
		Trainers updatedTrainers = trainersService.update(trainers);
		if (updatedTrainers == null) {
			return new ResponseEntity<Trainers>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Trainers>(updatedTrainers, HttpStatus.OK);
	}

	@RequestMapping(value = "/trainers/{id}", method = RequestMethod.GET)
	public ResponseEntity<Trainers> getTrainersByid(@PathVariable Long id) {
		Trainers trainers = trainersService.getTrainersById(id);
		if (trainers == null) {
			return new ResponseEntity<Trainers>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Trainers>(trainers, HttpStatus.OK);
	}

	@RequestMapping(value = "/trainers/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteTrainersByid(@PathVariable Long id) {
		Trainers existingTrainers = trainersService.getTrainersById(id);
		if (existingTrainers == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		trainersService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
