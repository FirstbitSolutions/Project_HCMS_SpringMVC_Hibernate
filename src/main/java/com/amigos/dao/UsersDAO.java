package com.amigos.dao;

import java.util.List;

import com.amigos.dto.Users;

public interface UsersDAO {

	List<Users> getAll();

	Users getUsersById(Long id);

	Long save(Users obj);

	Users update(Users obj);

	void delete(Long id);

}