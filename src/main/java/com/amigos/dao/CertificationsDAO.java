package com.amigos.dao;

import java.util.List;

import com.amigos.dto.Certifications;

public interface CertificationsDAO {

	List<Certifications> getAll();

	Certifications getCertificationsById(Long id);

	Long save(Certifications obj);

	Certifications update(Certifications obj);

	void delete(Long id);

}