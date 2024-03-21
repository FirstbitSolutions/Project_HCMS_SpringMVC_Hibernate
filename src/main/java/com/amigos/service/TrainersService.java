package com.amigos.service;

import java.util.List;

import com.amigos.dto.Trainers;

public interface TrainersService {

	List<Trainers> getAll();

	Trainers getTrainersById(Long id);

	Long save(Trainers obj);

	Trainers update(Trainers obj);

	void delete(Long id);

}