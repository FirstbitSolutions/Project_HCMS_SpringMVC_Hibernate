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

import com.amigos.dto.Projects;
import com.amigos.service.ProjectsService;

@RestController
public class ProjectsController {

	@Autowired
	private ProjectsService projectsService;

	@RequestMapping(value = "/projects", method = RequestMethod.GET)
	public ResponseEntity<List<Projects>> getProjectss() {
		List<Projects> projects = projectsService.getAll();
		if (projects.isEmpty()) {
			return new ResponseEntity<List<Projects>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<List<Projects>>(projects, HttpStatus.OK);
	}

	@RequestMapping(value = "/projects", method = RequestMethod.POST)
	public ResponseEntity<Void> saveProjects(@RequestBody Projects projects, UriComponentsBuilder ucBuilder) {
		if (projects == null) {
			throw new RuntimeException("Projects  are required fields");
		}
		Long id = projectsService.save(projects);
		HttpHeaders headers = new HttpHeaders();
		headers.setLocation(ucBuilder.path("/projects/{id}").buildAndExpand(id).toUri());
		return new ResponseEntity<Void>(headers, HttpStatus.CREATED);
	}

	@RequestMapping(value = "/projects", method = RequestMethod.PUT)
	public ResponseEntity<Projects> updateProjects(@RequestBody Projects projects) {
		if (projects == null || projects.getProjectId() <= 0) {
			throw new RuntimeException("Projects  are required fields");
		}
		Projects updatedProjects = projectsService.update(projects);
		if (updatedProjects == null) {
			return new ResponseEntity<Projects>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Projects>(updatedProjects, HttpStatus.OK);
	}

	@RequestMapping(value = "/projects/{id}", method = RequestMethod.GET)
	public ResponseEntity<Projects> getProjectsByid(@PathVariable Long id) {
		Projects projects = projectsService.getProjectsById(id);
		if (projects == null) {
			return new ResponseEntity<Projects>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Projects>(projects, HttpStatus.OK);
	}

	@RequestMapping(value = "/projects/{id}", method = RequestMethod.DELETE)
	public ResponseEntity<Void> deleteProjectsByid(@PathVariable Long id) {
		Projects existingProjects = projectsService.getProjectsById(id);
		if (existingProjects == null) {
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		}
		projectsService.delete(id);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}

}
