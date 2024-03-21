package com.amigos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.EmployeeManagersDAO;
import com.amigos.dto.EmployeeManagers;

@Service
public class EmployeeManagersServiceImpl implements EmployeeManagersService {

	@Autowired
	private EmployeeManagersDAO objDAO;

	@Override
	public List<EmployeeManagers> getAll() {
		return objDAO.getAll();
	}

	@Override
	public EmployeeManagers getEmployeeManagersById(Long id) {
		return objDAO.getEmployeeManagersById(id);
	}

	@Override
	public Long save(EmployeeManagers obj) {
		return objDAO.save(obj);
	}

	@Override
	public EmployeeManagers update(EmployeeManagers obj) {
		return objDAO.update(obj);
	}

	@Override
	public void delete(Long id) {
		objDAO.delete(id);
	}

}
