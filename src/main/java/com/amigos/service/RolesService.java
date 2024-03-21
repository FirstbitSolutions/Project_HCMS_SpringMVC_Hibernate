package com.amigos.service;

import java.util.List;

import com.amigos.dto.Roles;

public interface RolesService {

	List<Roles> getAll();

	Roles getRolesById(Long id);

	Long save(Roles obj);

	Roles update(Roles obj);

	void delete(Long id);
}
