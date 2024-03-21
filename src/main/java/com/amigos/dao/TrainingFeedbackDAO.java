package com.amigos.dao;

import java.util.List;

import com.amigos.dto.TrainingFeedback;

public interface TrainingFeedbackDAO {

	List<TrainingFeedback> getAll();

	TrainingFeedback getTrainingFeedbackById(Long id);

	Long save(TrainingFeedback obj);

	TrainingFeedback update(TrainingFeedback obj);

	void delete(Long id);

}