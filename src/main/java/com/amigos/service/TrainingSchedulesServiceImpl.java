package com.amigos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.TrainingSchedulesDAO;
import com.amigos.dto.TrainingSchedules;

@Service
public class TrainingSchedulesServiceImpl implements TrainingSchedulesService {

	@Autowired
	private TrainingSchedulesDAO objDAO;

	@Override
	public List<TrainingSchedules> getAll() {
		return objDAO.getAll();
	}

	@Override
	public TrainingSchedules getTrainingSchedulesById(Long id) {
		return objDAO.getTrainingSchedulesById(id);
	}

	@Override
	public Long save(TrainingSchedules obj) {
		return objDAO.save(obj);
	}

	@Override
	public TrainingSchedules update(TrainingSchedules obj) {
		return objDAO.update(obj);
	}

	@Override
	public void delete(Long id) {
		objDAO.delete(id);
	}

}
