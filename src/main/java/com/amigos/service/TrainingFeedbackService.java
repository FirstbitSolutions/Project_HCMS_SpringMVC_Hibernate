package com.amigos.service;

import java.util.List;

import com.amigos.dto.TrainingFeedback;

public interface TrainingFeedbackService {

	List<TrainingFeedback> getAll();

	TrainingFeedback getTrainingFeedbackById(Long id);

	Long save(TrainingFeedback obj);

	TrainingFeedback update(TrainingFeedback obj);

	void delete(Long id);

}