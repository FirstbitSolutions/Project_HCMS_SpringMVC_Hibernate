package com.amigos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.DepartmentsDAO;
import com.amigos.dto.Departments;

@Service
public class DepartmentsServiceImpl implements DepartmentsService {

	@Autowired
	private DepartmentsDAO objDAO;

	@Override
	public List<Departments> getAll() {
		return objDAO.getAll();
	}

	@Override
	public Departments getDepartmentsById(Long id) {
		return objDAO.getDepartmentsById(id);
	}

	@Override
	public Long save(Departments obj) {
		return objDAO.save(obj);
	}

	@Override
	public Departments update(Departments obj) {
		return objDAO.update(obj);
	 
	}

	@Override
	public void delete(Long id) {
		objDAO.delete(id);
	}

}
