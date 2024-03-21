package com.amigos.service;

import java.util.List;

import com.amigos.dto.Users;

public interface UsersService {

	List<Users> getAll();

	Users getUsersById(Long id);

	Long save(Users obj);

	Users update(Users obj);

	void delete(Long id);

}