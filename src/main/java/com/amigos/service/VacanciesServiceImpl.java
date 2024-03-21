package com.amigos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.VacanciesDAO;
import com.amigos.dto.Vacancies;

@Service
public class VacanciesServiceImpl implements VacanciesService {

	@Autowired
	private VacanciesDAO objDAO;

	@Override
	public List<Vacancies> getAll() {
		return objDAO.getAll();
	}

	@Override
	public Vacancies getVacanciesById(Long id) {
		return objDAO.getVacanciesById(id);
	}

	@Override
	public Long save(Vacancies obj) {
		return objDAO.save(obj);
	}

	@Override
	public Vacancies update(Vacancies obj) {
		return objDAO.update(obj);
	}

	@Override
	public void delete(Long id) {
		objDAO.delete(id);
	}

}
