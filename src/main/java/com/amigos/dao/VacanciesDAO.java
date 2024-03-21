package com.amigos.dao;

import java.util.List;

import com.amigos.dto.Vacancies;

public interface VacanciesDAO {

	List<Vacancies> getAll();

	Vacancies getVacanciesById(Long id);

	Long save(Vacancies obj);

	Vacancies update(Vacancies obj);

	void delete(Long id);

}