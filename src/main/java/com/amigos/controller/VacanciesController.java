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

import com.amigos.dto.Vacancies;
import com.amigos.service.VacanciesService;

@RestController
public class VacanciesController {

	@Autowired
	private VacanciesService vacanciesService;

	@RequestMapping(value = "/vacancies", method = RequestMethod.GET)
	public ResponseEntity<List<Vacancies>> getVacanciess() {
		List<Vacancies> vacancies = vacanciesService.getAll();
		if (vacancies.isEmpty()) {
			return new ResponseEntity<List<Vacancies>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Vacancies>>(vacancies, HttpStatus.OK);
	}

	@RequestMapping(value = "/vacancies", method = RequestMethod.POST)
	public ResponseEntity<Void> saveVacancies(@RequestBody Vacancies vacancies, UriComponentsBuilder ucBuilder) {
		if (vacancies == null) {
			throw new RuntimeException("Vacancies  are required fields");
		}
		Long id = vacanciesService.save(vacancies);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/vacancies/{id}").buildAndExpand(id).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/vacancies", method = RequestMethod.PUT)
	public ResponseEntity<Vacancies> updateVacancies(@RequestBody Vacancies vacancies) {
		if (vacancies == null || vacancies.getVacancyId() <= 0) {
			throw new RuntimeException("Vacancies  are required fields");
		}
		Vacancies updatedVacancies = vacanciesService.update(vacancies);
		if (updatedVacancies == null) {
			return new ResponseEntity<Vacancies>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Vacancies>(updatedVacancies, HttpStatus.OK);
	}

	@RequestMapping(value = "/vacancies/{id}", method = RequestMethod.GET)
	public ResponseEntity<Vacancies> getVacanciesByid(@PathVariable Long id) {
		Vacancies vacancies = vacanciesService.getVacanciesById(id);
		if (vacancies == null) {
			return new ResponseEntity<Vacancies>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Vacancies>(vacancies, HttpStatus.OK);
	}

	@RequestMapping(value = "/vacancies/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteVacanciesByid(@PathVariable Long id) {
		Vacancies existingVacancies = vacanciesService.getVacanciesById(id);
		if (existingVacancies == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		vacanciesService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
