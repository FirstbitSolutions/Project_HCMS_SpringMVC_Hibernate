package com.amigos.service;

import java.util.List;

import com.amigos.dto.AppraisalForms;

public interface AppraisalFormsService {

	List<AppraisalForms> getAll();

	AppraisalForms getAppraisalFormsById(Long id);

	Long save(AppraisalForms obj);

	AppraisalForms update(AppraisalForms obj);

	void delete(Long id);
}
