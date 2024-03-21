package com.amigos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.TrainingModulesDAO;
import com.amigos.dto.TrainingModules;

@Service
public class TrainingModulesServiceImpl implements TrainingModulesService {

	@Autowired
	private TrainingModulesDAO objDAO;

	@Override
	public List<TrainingModules> getAll() {
		return objDAO.getAll();
	}

	@Override
	public TrainingModules getTrainingModulesById(Long id) {
		return objDAO.getTrainingModulesById(id);
	}

	@Override
	public Long save(TrainingModules obj) {
		return objDAO.save(obj);
	}

	@Override
	public TrainingModules update(TrainingModules obj) {
		return objDAO.update(obj);
	}

	@Override
	public void delete(Long id) {
		objDAO.delete(id);
	}

}
