package com.amigos.dao;

import java.util.List;

import com.amigos.dto.CandidateProfiles;

public interface CandidateProfilesDAO {

	List<CandidateProfiles> getAll();

	CandidateProfiles getCandidateProfilesById(Long id);

	Long save(CandidateProfiles obj);

	CandidateProfiles update(CandidateProfiles obj);

	void delete(Long id);

}