package com.amigos.dao;

import java.util.List;

import com.amigos.dto.Departments;

public interface DepartmentsDAO {

	List<Departments> getAll();

	Departments getDepartmentsById(Long id);

	Long save(Departments obj);

	Departments update(Departments obj);

	void delete(Long id);

}