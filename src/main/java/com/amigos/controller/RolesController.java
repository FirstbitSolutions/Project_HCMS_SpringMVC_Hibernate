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

import com.amigos.dto.Roles;
import com.amigos.service.RolesService;

@RestController
public class RolesController {

	@Autowired
	private RolesService rolesService;

	@RequestMapping(value = "/roles", method = RequestMethod.GET)
	public ResponseEntity<List<Roles>> getRoless() {
		List<Roles> roles = rolesService.getAll();
		if (roles.isEmpty()) {
			return new ResponseEntity<List<Roles>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Roles>>(roles, HttpStatus.OK);
	}

	@RequestMapping(value = "/roles", method = RequestMethod.POST)
	public ResponseEntity<Void> saveRoles(@RequestBody Roles roles, UriComponentsBuilder ucBuilder) {
		if (roles == null) {
			throw new RuntimeException("Roles  are required fields");
		}
		Long id = rolesService.save(roles);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/roles/{id}").buildAndExpand(id).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/roles", method = RequestMethod.PUT)
	public ResponseEntity<Roles> updateRoles(@RequestBody Roles roles) {
		if (roles == null || roles.getRoleId() <= 0) {
			throw new RuntimeException("Roles  are required fields");
		}
		Roles updatedRoles = rolesService.update(roles);
		if (updatedRoles == null) {
			return new ResponseEntity<Roles>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Roles>(updatedRoles, HttpStatus.OK);
	}

	@RequestMapping(value = "/roles/{id}", method = RequestMethod.GET)
	public ResponseEntity<Roles> getRolesByid(@PathVariable Long id) {
		Roles roles = rolesService.getRolesById(id);
		if (roles == null) {
			return new ResponseEntity<Roles>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Roles>(roles, HttpStatus.OK);
	}

	@RequestMapping(value = "/roles/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteRolesByid(@PathVariable Long id) {
		Roles existingRoles = rolesService.getRolesById(id);
		if (existingRoles == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		rolesService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
