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

import com.amigos.dto.EmployeeManagers;
import com.amigos.service.EmployeeManagersService;

@RestController
public class EmployeeManagersController {

	@Autowired
	private EmployeeManagersService employeeManagersService;

	@RequestMapping(value = "/employeeManagers", method = RequestMethod.GET)
	public ResponseEntity<List<EmployeeManagers>> getEmployeeManagerss() {
		List<EmployeeManagers> employeeManagers = employeeManagersService.getAll();
		if (employeeManagers.isEmpty()) {
			return new ResponseEntity<List<EmployeeManagers>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<EmployeeManagers>>(employeeManagers, HttpStatus.OK);
	}

	@RequestMapping(value = "/employeeManagers", method = RequestMethod.POST)
	public ResponseEntity<Void> saveEmployeeManagers(@RequestBody EmployeeManagers employeeManagers,
			UriComponentsBuilder ucBuilder) {
		if (employeeManagers == null) {
			throw new RuntimeException("EmployeeManagers  are required fields");
		}
		Long id = employeeManagersService.save(employeeManagers);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/employeeManagers/{id}").buildAndExpand(id).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/employeeManagers", method = RequestMethod.PUT)
	public ResponseEntity<EmployeeManagers> updateEmployeeManagers(@RequestBody EmployeeManagers employeeManagers) {
		if (employeeManagers == null || employeeManagers.getRelationshipId() <= 0) {
			throw new RuntimeException("EmployeeManagers  are required fields");
		}
		EmployeeManagers updatedEmployeeManagers = employeeManagersService.update(employeeManagers);
		if (updatedEmployeeManagers == null) {
			return new ResponseEntity<EmployeeManagers>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<EmployeeManagers>(updatedEmployeeManagers, HttpStatus.OK);
	}

	@RequestMapping(value = "/employeeManagers/{id}", method = RequestMethod.GET)
	public ResponseEntity<EmployeeManagers> getEmployeeManagersByid(@PathVariable Long id) {
		EmployeeManagers employeeManagers = employeeManagersService.getEmployeeManagersById(id);
		if (employeeManagers == null) {
			return new ResponseEntity<EmployeeManagers>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<EmployeeManagers>(employeeManagers, HttpStatus.OK);
	}

	@RequestMapping(value = "/employeeManagers/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteEmployeeManagersByid(@PathVariable Long id) {
		EmployeeManagers existingEmployeeManagers = employeeManagersService.getEmployeeManagersById(id);
		if (existingEmployeeManagers == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		employeeManagersService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
