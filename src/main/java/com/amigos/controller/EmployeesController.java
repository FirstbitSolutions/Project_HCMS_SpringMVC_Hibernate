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

import com.amigos.dto.Employees;
import com.amigos.service.EmployeesService;

@RestController
public class EmployeesController {

	@Autowired
	private EmployeesService employeesService;

	@RequestMapping(value = "/employees", method = RequestMethod.GET)
	public ResponseEntity<List<Employees>> getEmployeess() {
		List<Employees> employees = employeesService.getAll();
		if (employees.isEmpty()) {
			return new ResponseEntity<List<Employees>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Employees>>(employees, HttpStatus.OK);
	}

	@RequestMapping(value = "/employees", method = RequestMethod.POST)
	public ResponseEntity<Void> saveEmployees(@RequestBody Employees employees, UriComponentsBuilder ucBuilder) {
		if (employees == null || employees.getFirstName() == null || "".equals(employees.getFirstName())) {
			throw new RuntimeException("Employees FirstName  are required fields");
		}
		Long id = employeesService.save(employees);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/employees/{id}").buildAndExpand(id).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/employees", method = RequestMethod.PUT)
	public ResponseEntity<Employees> updateEmployees(@RequestBody Employees employees) {
		if (employees == null || employees.getFirstName() == null || "".equals(employees.getFirstName())
				|| employees.getEmployeeId() <= 0) {
			throw new RuntimeException("Employees FirstName, Id  are required fields");
		}
		Employees updatedEmployees = employeesService.update(employees);
		if (updatedEmployees == null) {
			return new ResponseEntity<Employees>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Employees>(updatedEmployees, HttpStatus.OK);
	}

	@RequestMapping(value = "/employees/{id}", method = RequestMethod.GET)
	public ResponseEntity<Employees> getEmployeesByid(@PathVariable Long id) {
		Employees employees = employeesService.getEmployeesById(id);
		if (employees == null) {
			return new ResponseEntity<Employees>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Employees>(employees, HttpStatus.OK);
	}

	@RequestMapping(value = "/employees/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteEmployeesByid(@PathVariable Long id) {
		Employees existingEmployees = employeesService.getEmployeesById(id);
		if (existingEmployees == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		employeesService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}