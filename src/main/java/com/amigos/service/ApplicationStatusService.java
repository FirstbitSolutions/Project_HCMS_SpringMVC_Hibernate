package com.amigos.service;

import java.util.List;

import com.amigos.dto.ApplicationStatus;

public interface ApplicationStatusService {

	List<ApplicationStatus> getAll();

	ApplicationStatus getApplicationStatusById(Long id);

	Long save(ApplicationStatus obj);

	ApplicationStatus update(ApplicationStatus obj);

	void delete(Long id);

}