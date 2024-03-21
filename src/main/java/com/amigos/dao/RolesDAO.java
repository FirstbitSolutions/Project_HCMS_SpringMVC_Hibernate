package com.amigos.dao;

import java.util.List;

import com.amigos.dto.Roles;

public interface RolesDAO {

	List<Roles> getAll();

	Roles getRolesById(Long id);

	Long save(Roles obj);

	Roles update(Roles obj);

	void delete(Long id);

}
