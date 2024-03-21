package com.amigos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.CertificationsDAO;
import com.amigos.dto.Certifications;

@Service
public class CertificationsServiceImpl implements CertificationsService {

	@Autowired
	private CertificationsDAO objDAO;

	@Override
	public List<Certifications> getAll() {
		return objDAO.getAll();
	}

	@Override
	public Certifications getCertificationsById(Long id) {
		return objDAO.getCertificationsById(id);
	}

	@Override
	public Long save(Certifications obj) {
		return objDAO.save(obj);
	}

	@Override
	public Certifications update(Certifications obj) {
		return objDAO.update(obj);
	}

	@Override
	public void delete(Long id) {
		objDAO.delete(id);
	}

}
