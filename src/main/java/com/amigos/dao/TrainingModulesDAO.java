package com.amigos.dao;

import java.util.List;

import com.amigos.dto.TrainingModules;

public interface TrainingModulesDAO {

	List<TrainingModules> getAll();

	TrainingModules getTrainingModulesById(Long id);

	Long save(TrainingModules obj);

	TrainingModules update(TrainingModules obj);

	void delete(Long id);

}