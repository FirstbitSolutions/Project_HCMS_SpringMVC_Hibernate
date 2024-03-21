package com.amigos.service;

import java.util.List;

import com.amigos.dto.EmployeeManagers;

public interface EmployeeManagersService {

	List<EmployeeManagers> getAll();

	EmployeeManagers getEmployeeManagersById(Long id);

	Long save(EmployeeManagers obj);

	EmployeeManagers update(EmployeeManagers obj);

	void delete(Long id);

}
