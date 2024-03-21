package com.amigos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.TrainersDAO;
import com.amigos.dto.Trainers;

@Service
public class TrainersServiceImpl implements TrainersService {

	@Autowired
	private TrainersDAO objDAO;

	@Override
	public List<Trainers> getAll() {
		return objDAO.getAll();
	}

	@Override
	public Trainers getTrainersById(Long id) {
		return objDAO.getTrainersById(id);
	}

	@Override
	public Long save(Trainers obj) {
		return objDAO.save(obj);
	}

	@Override
	public Trainers update(Trainers obj) {
		return objDAO.update(obj);
	}

	@Override
	public void delete(Long id) {
		objDAO.delete(id);
	}

}
