package com.amigos.service;

import java.util.List;

import com.amigos.dto.Vacancies;

public interface VacanciesService {

	List<Vacancies> getAll();

	Vacancies getVacanciesById(Long id);

	Long save(Vacancies obj);

	Vacancies update(Vacancies obj);

	void delete(Long id);

}