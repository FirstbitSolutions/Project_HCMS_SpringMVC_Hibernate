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

import com.amigos.dto.SkillUpgradation;
import com.amigos.service.SkillUpgradationService;

@RestController
public class SkillUpgradationController {

	@Autowired
	private SkillUpgradationService skillUpgradationService;

	@RequestMapping(value = "/skillUpgradation", method = RequestMethod.GET)
	public ResponseEntity<List<SkillUpgradation>> getSkillUpgradations() {
		List<SkillUpgradation> skillUpgradation = skillUpgradationService.getAll();
		if (skillUpgradation.isEmpty()) {
			return new ResponseEntity<List<SkillUpgradation>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<SkillUpgradation>>(skillUpgradation, HttpStatus.OK);
	}

	@RequestMapping(value = "/skillUpgradation", method = RequestMethod.POST)
	public ResponseEntity<Void> saveSkillUpgradation(@RequestBody SkillUpgradation skillUpgradation,
			UriComponentsBuilder ucBuilder) {
		if (skillUpgradation == null) {
			throw new RuntimeException("SkillUpgradation  are required fields");
		}
		Long id = skillUpgradationService.save(skillUpgradation);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/skillUpgradation/{id}").buildAndExpand(id).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/skillUpgradation", method = RequestMethod.PUT)
	public ResponseEntity<SkillUpgradation> updateSkillUpgradation(@RequestBody SkillUpgradation skillUpgradation) {
		if (skillUpgradation == null || skillUpgradation.getUpgradationId() <= 0) {
			throw new RuntimeException("SkillUpgradation  are required fields");
		}
		SkillUpgradation updatedSkillUpgradation = skillUpgradationService.update(skillUpgradation);
		if (updatedSkillUpgradation == null) {
			return new ResponseEntity<SkillUpgradation>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<SkillUpgradation>(HttpStatus.OK);
	}

	@RequestMapping(value = "/skillUpgradation/{id}", method = RequestMethod.GET)
	public ResponseEntity<SkillUpgradation> getSkillUpgradationByid(@PathVariable Long id) {
		SkillUpgradation skillUpgradation = skillUpgradationService.getSkillUpgradationById(id);
		if (skillUpgradation == null) {
			return new ResponseEntity<SkillUpgradation>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<SkillUpgradation>(skillUpgradation, HttpStatus.OK);
	}

	@RequestMapping(value = "/skillUpgradation/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteSkillUpgradationByid(@PathVariable Long id) {
		SkillUpgradation existingSkillUpgradation = skillUpgradationService.getSkillUpgradationById(id);
		if (existingSkillUpgradation == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		skillUpgradationService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
