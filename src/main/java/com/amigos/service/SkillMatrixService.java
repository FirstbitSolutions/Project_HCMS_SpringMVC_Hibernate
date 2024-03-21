package com.amigos.service;

import java.util.List;

import com.amigos.dto.SkillMatrix;

public interface SkillMatrixService {

	List<SkillMatrix> getAll();

	SkillMatrix getSkillMatrixById(Long id);

	Long save(SkillMatrix obj);

	SkillMatrix update(SkillMatrix obj);

	void delete(Long id);

}
