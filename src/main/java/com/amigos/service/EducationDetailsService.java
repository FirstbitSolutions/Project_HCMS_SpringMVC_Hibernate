package com.amigos.service;



import java.util.List;

import com.amigos.dto.EducationDetails;

public interface EducationDetailsService {

	List<EducationDetails> getAll();

	EducationDetails getEducationDetailsById(Long id);

	Long save(EducationDetails obj);

	EducationDetails update(EducationDetails obj);

	void delete(Long id);

}