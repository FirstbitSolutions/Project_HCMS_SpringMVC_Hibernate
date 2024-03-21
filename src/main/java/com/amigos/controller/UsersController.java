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

import com.amigos.dto.Users;
import com.amigos.service.UsersService;

@RestController
public class UsersController {

	@Autowired
	private UsersService usersService;

	@RequestMapping(value = "/users", method = RequestMethod.GET)
	public ResponseEntity<List<Users>> getUserss() {
		List<Users> users = usersService.getAll();
		if (users.isEmpty()) {
			return new ResponseEntity<List<Users>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Users>>(users, HttpStatus.OK);
	}

	@RequestMapping(value = "/users", method = RequestMethod.POST)
	public ResponseEntity<Void> saveUsers(@RequestBody Users users, UriComponentsBuilder ucBuilder) {
		if (users == null) {
			throw new RuntimeException("Users  are required fields");
		}
		Long id = usersService.save(users);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/users/{id}").buildAndExpand(id).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/users", method = RequestMethod.PUT)
	public ResponseEntity<Users> updateUsers(@RequestBody Users users) {
		if (users == null || users.getUserId() <= 0) {
			throw new RuntimeException("Users  are required fields");
		}
		Users updatedUsers = usersService.update(users);
		if (updatedUsers == null) {
			return new ResponseEntity<Users>(HttpStatus.NOT_FOUND);
		}

		return new ResponseEntity<Users>(updatedUsers, HttpStatus.OK);
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.GET)
	public ResponseEntity<Users> getUsersByid(@PathVariable Long id) {
		Users users = usersService.getUsersById(id);
		if (users == null) {
			return new ResponseEntity<Users>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Users>(users, HttpStatus.OK);
	}

	@RequestMapping(value = "/users/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteUsersByid(@PathVariable Long id) {
		Users existingUsers = usersService.getUsersById(id);
		if (existingUsers == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		usersService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
