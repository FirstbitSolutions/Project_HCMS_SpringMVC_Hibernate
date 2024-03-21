package com.amigos.service;

import java.util.List;

import com.amigos.dto.TrainingSchedules;

public interface TrainingSchedulesService {

	List<TrainingSchedules> getAll();

	TrainingSchedules getTrainingSchedulesById(Long id);

	Long save(TrainingSchedules obj);

	TrainingSchedules update(TrainingSchedules obj);

	void delete(Long id);

}
