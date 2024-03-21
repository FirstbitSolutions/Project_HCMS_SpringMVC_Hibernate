package com.amigos.dao;

import java.util.List;

import com.amigos.dto.TrainingSchedules;

public interface TrainingSchedulesDAO {

	List<TrainingSchedules> getAll();

	TrainingSchedules getTrainingSchedulesById(Long id);

	Long save(TrainingSchedules obj);

	TrainingSchedules update(TrainingSchedules obj);

	void delete(Long id);

}
