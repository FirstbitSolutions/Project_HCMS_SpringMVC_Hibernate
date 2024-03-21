package com.amigos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.EducationDetailsDAO;
import com.amigos.dto.EducationDetails;

@Service
public class EducationDetailsServiceImpl implements EducationDetailsService {

	@Autowired
	private EducationDetailsDAO objDAO;

	@Override
	public List<EducationDetails> getAll() {
		return objDAO.getAll();
	}

	@Override
	public EducationDetails getEducationDetailsById(Long id) {
		return objDAO.getEducationDetailsById(id);
	}

	@Override
	public Long save(EducationDetails obj) {
		return objDAO.save(obj);
	}

	@Override
	public EducationDetails update(EducationDetails obj) {
		return objDAO.update(obj);
	}

	@Override
	public void delete(Long id) {
		objDAO.delete(id);
	}

}
