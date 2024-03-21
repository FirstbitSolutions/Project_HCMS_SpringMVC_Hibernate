package com.amigos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.SkillUpgradationDAO;
import com.amigos.dto.SkillUpgradation;

@Service
public class SkillUpgradationServiceImpl implements SkillUpgradationService {

	@Autowired
	private SkillUpgradationDAO objDAO;

	@Override
	public List<SkillUpgradation> getAll() {
		return objDAO.getAll();
	}

	@Override
	public SkillUpgradation getSkillUpgradationById(Long id) {
		return objDAO.getSkillUpgradationById(id);
	}

	@Override
	public Long save(SkillUpgradation obj) {
		return objDAO.save(obj);
	}

	@Override
	public SkillUpgradation update(SkillUpgradation obj) {
		return objDAO.update(obj);
	}

	@Override
	public void delete(Long id) {
		objDAO.delete(id);
	}

}
