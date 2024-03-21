package com.amigos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.ProjectsDAO;
import com.amigos.dto.Projects;

@Service
public class ProjectsServiceImpl implements ProjectsService {

	@Autowired
	private ProjectsDAO objDAO;

	@Override
	public List<Projects> getAll() {
		return objDAO.getAll();
	}

	@Override
	public Projects getProjectsById(Long id) {
		return objDAO.getProjectsById(id);
	}

	@Override
	public Long save(Projects obj) {
		return objDAO.save(obj);
	}

	@Override
	public Projects update(Projects obj) {
		return objDAO.update(obj);
	}

	@Override
	public void delete(Long id) {
		objDAO.delete(id);
	}

}
