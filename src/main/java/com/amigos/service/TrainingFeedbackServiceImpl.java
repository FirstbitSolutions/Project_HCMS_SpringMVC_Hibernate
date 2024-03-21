package com.amigos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.TrainingFeedbackDAO;
import com.amigos.dto.TrainingFeedback;

@Service
public class TrainingFeedbackServiceImpl implements TrainingFeedbackService {

	@Autowired
	private TrainingFeedbackDAO objDAO;

	@Override
	public List<TrainingFeedback> getAll() {
		return objDAO.getAll();
	}

	@Override
	public TrainingFeedback getTrainingFeedbackById(Long id) {
		return objDAO.getTrainingFeedbackById(id);
	}

	@Override
	public Long save(TrainingFeedback obj) {
		return objDAO.save(obj);
	}

	@Override
	public TrainingFeedback update(TrainingFeedback obj) {
		return objDAO.update(obj);
	}

	@Override
	public void delete(Long id) {
		objDAO.delete(id);
	}

}
