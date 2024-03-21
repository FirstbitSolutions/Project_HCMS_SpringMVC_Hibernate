package com.amigos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.UsersDAO;
import com.amigos.dto.Users;

@Service
public class UsersServiceImpl implements UsersService {

	@Autowired
	private UsersDAO objDAO;

	@Override
	public List<Users> getAll() {
		return objDAO.getAll();
	}

	@Override
	public Users getUsersById(Long id) {
		return objDAO.getUsersById(id);
	}

	@Override
	public Long save(Users obj) {
		return objDAO.save(obj);
	}

	@Override
	public Users update(Users obj) {
		return objDAO.update(obj);
	}

	@Override
	public void delete(Long id) {
		objDAO.delete(id);
	}

}
