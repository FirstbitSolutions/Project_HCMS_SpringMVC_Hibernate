package com.amigos.dao;

import java.util.List;

import com.amigos.dto.Projects;

public interface ProjectsDAO {

	List<Projects> getAll();

	Projects getProjectsById(Long id);

	Long save(Projects obj);

	Projects update(Projects obj);

	void delete(Long id);

}