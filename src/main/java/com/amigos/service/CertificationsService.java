package com.amigos.service;

import java.util.List;

import com.amigos.dto.Certifications;

public interface CertificationsService {

	List<Certifications> getAll();

	Certifications getCertificationsById(Long id);

	Long save(Certifications obj);

	Certifications update(Certifications obj);

	void delete(Long id);

}