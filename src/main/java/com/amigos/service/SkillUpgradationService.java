package com.amigos.service;

import java.util.List;

import com.amigos.dto.SkillUpgradation;

public interface SkillUpgradationService {

	List<SkillUpgradation> getAll();

	SkillUpgradation getSkillUpgradationById(Long id);

	Long save(SkillUpgradation obj);

	SkillUpgradation update(SkillUpgradation obj);

	void delete(Long id);

}
