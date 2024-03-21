package com.amigos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.RolesDAO;
import com.amigos.dto.Roles;

@Service
public class RolesServiceImpl implements RolesService {

	@Autowired
	private RolesDAO objDAO;

	@Override
	public List<Roles> getAll() {
		return objDAO.getAll();
	}

	@Override
	public Roles getRolesById(Long id) {
		return objDAO.getRolesById(id);
	}

	@Override
	public Long save(Roles obj) {
		return objDAO.save(obj);
	}

	@Override
	public Roles update(Roles obj) {
		return objDAO.update(obj);
	}

	@Override
	public void delete(Long id) {
		objDAO.delete(id);
	}

}
