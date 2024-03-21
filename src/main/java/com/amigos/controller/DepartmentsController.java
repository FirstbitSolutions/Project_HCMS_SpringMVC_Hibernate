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

import com.amigos.dto.Departments;
import com.amigos.service.DepartmentsService;

@RestController
public class DepartmentsController {

	@Autowired
	private DepartmentsService departmentsService;

	@RequestMapping(value = "/departments", method = RequestMethod.GET)
	public ResponseEntity<List<Departments>> getDepartmentss() {
		List<Departments> departments = departmentsService.getAll();
		if (departments.isEmpty()) {
			return new ResponseEntity<List<Departments>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Departments>>(departments, HttpStatus.OK);
	}

	@RequestMapping(value = "/departments", method = RequestMethod.POST)
	public ResponseEntity<Void> saveDepartments(@RequestBody Departments departments, UriComponentsBuilder ucBuilder) {
		if (departments == null) {
			throw new RuntimeException("Departments  are required fields");
		}
		Long id = departmentsService.save(departments);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/departments/{id}").buildAndExpand(id).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/departments", method = RequestMethod.PUT)
	public ResponseEntity<Departments> updateDepartments(@RequestBody Departments departments) {
		if (departments == null || departments.getDepartmentId() <= 0) {
			throw new RuntimeException("Departments  are required fields");
		}
		Departments updatedDepartments = 	departmentsService.update(departments);
		if (updatedDepartments == null) {
			return new ResponseEntity<Departments>(HttpStatus.NOT_FOUND);
		}
	
		return new ResponseEntity<Departments>(updatedDepartments,HttpStatus.OK);
	}

	@RequestMapping(value = "/departments/{id}", method = RequestMethod.GET)
	public ResponseEntity<Departments> getDepartmentsByid(@PathVariable Long id) {
		Departments departments = departmentsService.getDepartmentsById(id);
		if (departments == null) {
			return new ResponseEntity<Departments>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Departments>(departments, HttpStatus.OK);
	}

	@RequestMapping(value = "/departments/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteDepartmentsByid(@PathVariable Long id) {
		Departments existingDepartments = departmentsService.getDepartmentsById(id);
		if (existingDepartments == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		departmentsService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
