package com.amigos.service;

import java.util.List;

import com.amigos.dto.Employees;

public interface EmployeesService {

	List<Employees> getAll();

	Employees getEmployeesById(Long id);

	Long save(Employees obj);

	Employees update(Employees obj);

	void delete(Long id);

}