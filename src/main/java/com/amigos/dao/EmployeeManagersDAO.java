package com.amigos.dao;

import java.util.List;

import com.amigos.dto.EmployeeManagers;

public interface EmployeeManagersDAO {

	List<EmployeeManagers> getAll();

	EmployeeManagers getEmployeeManagersById(Long id);

	Long save(EmployeeManagers obj);

	EmployeeManagers update(EmployeeManagers obj);

	void delete(Long id);

}
