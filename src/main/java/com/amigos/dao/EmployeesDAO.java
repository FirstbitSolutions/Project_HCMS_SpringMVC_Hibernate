package com.amigos.dao;

import java.util.List;

import com.amigos.dto.Employees;

public interface EmployeesDAO {

	List<Employees> getAll();

	Employees getEmployeesById(Long id);

	Long save(Employees obj);

	Employees update(Employees obj);

	void delete(Long id);

}