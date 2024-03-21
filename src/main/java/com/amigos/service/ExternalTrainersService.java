package com.amigos.service;

import java.util.List;

import com.amigos.dto.ExternalTrainers;

public interface ExternalTrainersService {

	List<ExternalTrainers> getAll();

	ExternalTrainers getExternalTrainersById(Long id);

	Long save(ExternalTrainers obj);

	ExternalTrainers update(ExternalTrainers obj);

	void delete(Long id);

}