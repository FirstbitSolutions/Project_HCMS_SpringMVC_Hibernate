package com.amigos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.ApplicationStatusDAO;
import com.amigos.dto.ApplicationStatus;

@Service
public class ApplicationStatusServiceImpl implements ApplicationStatusService {

	@Autowired
	private ApplicationStatusDAO objDAO;

	@Override
	public List<ApplicationStatus> getAll() {
		return objDAO.getAll();
	}

	@Override
	public ApplicationStatus getApplicationStatusById(Long id) {
		return objDAO.getApplicationStatusById(id);
	}

	@Override
	public Long save(ApplicationStatus obj) {
		return objDAO.save(obj);
	}

	@Override
	public ApplicationStatus update(ApplicationStatus obj) {
		return objDAO.update(obj);
	}

	@Override
	public void delete(Long id) {
		objDAO.delete(id);
	}

}
