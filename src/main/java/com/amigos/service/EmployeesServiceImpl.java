package com.amigos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.EmployeesDAO;
import com.amigos.dto.Employees;

@Service
public class EmployeesServiceImpl implements EmployeesService {

	@Autowired
	private EmployeesDAO objDAO;

	@Override
	public List<Employees> getAll() {
		return objDAO.getAll();
	}

	@Override
	public Employees getEmployeesById(Long id) {
		return objDAO.getEmployeesById(id);
	}

	@Override
	public Long save(Employees obj) {
		return objDAO.save(obj);
	}

	@Override
	public Employees update(Employees obj) {
		return objDAO.update(obj);
	}

	@Override
	public void delete(Long id) {
		objDAO.delete(id);
	}


}
