package com.amigos.service;



import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.CandidateProfilesDAO;
import com.amigos.dto.CandidateProfiles;

@Service
public class CandidateProfilesServiceImpl implements CandidateProfilesService {

	@Autowired
	private CandidateProfilesDAO objDAO;

	@Override
	public List<CandidateProfiles> getAll() {
		return objDAO.getAll();
	}

	@Override
	public CandidateProfiles getCandidateProfilesById(Long id) {
		return objDAO.getCandidateProfilesById(id);
	}

	@Override
	public Long save(CandidateProfiles obj) {
		return objDAO.save(obj);
	}

	@Override
	public CandidateProfiles update(CandidateProfiles obj) {
		return objDAO.update(obj);
	}

	@Override
	public void delete(Long id) {
		objDAO.delete(id);
	}

}
