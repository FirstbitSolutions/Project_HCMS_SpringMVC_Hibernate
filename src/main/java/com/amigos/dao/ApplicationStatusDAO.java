package com.amigos.dao;

import java.util.List;

import com.amigos.dto.ApplicationStatus;

public interface ApplicationStatusDAO {

	List<ApplicationStatus> getAll();

	ApplicationStatus getApplicationStatusById(Long id);

	Long save(ApplicationStatus obj);

	ApplicationStatus update(ApplicationStatus obj);

	void delete(Long id);

}