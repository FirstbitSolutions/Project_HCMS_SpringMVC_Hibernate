package com.amigos.service;

import java.util.List;

import com.amigos.dto.TrainingModules;

public interface TrainingModulesService {

	List<TrainingModules> getAll();

	TrainingModules getTrainingModulesById(Long id);

	Long save(TrainingModules obj);

	TrainingModules update(TrainingModules obj);

	void delete(Long id);

}