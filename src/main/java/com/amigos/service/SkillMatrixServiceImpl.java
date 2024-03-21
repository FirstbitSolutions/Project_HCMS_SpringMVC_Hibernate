package com.amigos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.SkillMatrixDAO;
import com.amigos.dto.SkillMatrix;

@Service
public class SkillMatrixServiceImpl implements SkillMatrixService {

	@Autowired
	private SkillMatrixDAO objDAO;

	@Override
	public List<SkillMatrix> getAll() {
		return objDAO.getAll();
	}

	@Override
	public SkillMatrix getSkillMatrixById(Long id) {
		return objDAO.getSkillMatrixById(id);
	}

	@Override
	public Long save(SkillMatrix obj) {
		return objDAO.save(obj);
	}

	@Override
	public SkillMatrix update(SkillMatrix obj) {
		return objDAO.update(obj);
	}

	@Override
	public void delete(Long id) {
		objDAO.delete(id);
	}

}
