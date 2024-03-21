package com.amigos.dao;

import java.util.List;

import com.amigos.dto.SkillMatrix;

public interface SkillMatrixDAO {

	List<SkillMatrix> getAll();

	SkillMatrix getSkillMatrixById(Long id);

	Long save(SkillMatrix obj);

	SkillMatrix update(SkillMatrix obj);

	void delete(Long id);

}
