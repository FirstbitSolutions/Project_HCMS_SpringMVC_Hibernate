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

import com.amigos.dto.SkillMatrix;
import com.amigos.service.SkillMatrixService;

@RestController
public class SkillMatrixController {

	@Autowired
	private SkillMatrixService skillMatrixService;

	@RequestMapping(value = "/skillMatrix", method = RequestMethod.GET)
	public ResponseEntity<List<SkillMatrix>> getSkillMatrixs() {
		List<SkillMatrix> skillMatrix = skillMatrixService.getAll();
		if (skillMatrix.isEmpty()) {
			return new ResponseEntity<List<SkillMatrix>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<SkillMatrix>>(skillMatrix, HttpStatus.OK);
	}

	@RequestMapping(value = "/skillMatrix", method = RequestMethod.POST)
	public ResponseEntity<Void> saveSkillMatrix(@RequestBody SkillMatrix skillMatrix, UriComponentsBuilder ucBuilder) {
		if (skillMatrix == null) {
			throw new RuntimeException("SkillMatrix  are required fields");
		}
		Long id = skillMatrixService.save(skillMatrix);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/skillMatrix/{id}").buildAndExpand(id).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/skillMatrix", method = RequestMethod.PUT)
	public ResponseEntity<SkillMatrix> updateSkillMatrix(@RequestBody SkillMatrix skillMatrix) {
		if (skillMatrix == null || skillMatrix.getMatrixId() <= 0) {
			throw new RuntimeException("SkillMatrix  are required fields");
		}
		SkillMatrix updatedSkillMatrix = skillMatrixService.update(skillMatrix);
		if (updatedSkillMatrix == null) {
			return new ResponseEntity<SkillMatrix>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<SkillMatrix>(updatedSkillMatrix, HttpStatus.OK);
	}

	@RequestMapping(value = "/skillMatrix/{id}", method = RequestMethod.GET)
	public ResponseEntity<SkillMatrix> getSkillMatrixByid(@PathVariable Long id) {
		SkillMatrix skillMatrix = skillMatrixService.getSkillMatrixById(id);
		if (skillMatrix == null) {
			return new ResponseEntity<SkillMatrix>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<SkillMatrix>(skillMatrix, HttpStatus.OK);
	}

	@RequestMapping(value = "/skillMatrix/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteSkillMatrixByid(@PathVariable Long id) {
		SkillMatrix existingSkillMatrix = skillMatrixService.getSkillMatrixById(id);
		if (existingSkillMatrix == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		skillMatrixService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
