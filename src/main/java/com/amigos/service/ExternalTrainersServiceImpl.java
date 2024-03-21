package com.amigos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.ExternalTrainersDAO;
import com.amigos.dto.ExternalTrainers;

@Service
public class ExternalTrainersServiceImpl implements ExternalTrainersService {

	@Autowired
	private ExternalTrainersDAO objDAO;

	@Override
	public List<ExternalTrainers> getAll() {
		return objDAO.getAll();
	}

	@Override
	public ExternalTrainers getExternalTrainersById(Long id) {
		return objDAO.getExternalTrainersById(id);
	}

	@Override
	public Long save(ExternalTrainers obj) {
		return objDAO.save(obj);
	}

	@Override
	public ExternalTrainers update(ExternalTrainers obj) {
		return objDAO.update(obj);

	}

	@Override
	public void delete(Long id) {
		objDAO.delete(id);
	}

}
