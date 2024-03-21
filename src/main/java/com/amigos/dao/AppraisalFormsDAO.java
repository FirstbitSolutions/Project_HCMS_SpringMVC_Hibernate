package com.amigos.dao;

import java.util.List;

import com.amigos.dto.AppraisalForms;

public interface AppraisalFormsDAO {

	List<AppraisalForms> getAll();

	AppraisalForms getAppraisalFormsById(Long id);

	Long save(AppraisalForms obj);

	AppraisalForms update(AppraisalForms obj);

	void delete(Long id);

}
