package com.amigos.dao;

import java.util.List;

import com.amigos.dto.Trainers;

public interface TrainersDAO {

	List<Trainers> getAll();

	Trainers getTrainersById(Long id);

	Long save(Trainers obj);

	Trainers update(Trainers obj);

	void delete(Long id);

}