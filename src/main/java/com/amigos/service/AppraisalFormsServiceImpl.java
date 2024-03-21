package com.amigos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.AppraisalFormsDAO;
import com.amigos.dto.AppraisalForms;

@Service
public class AppraisalFormsServiceImpl implements AppraisalFormsService {

	@Autowired
	private AppraisalFormsDAO objDAO;

	@Override
	public List<AppraisalForms> getAll() {
		return objDAO.getAll();
	}

	@Override
	public AppraisalForms getAppraisalFormsById(Long id) {
		return objDAO.getAppraisalFormsById(id);
	}

	@Override
	public Long save(AppraisalForms obj) {
		return objDAO.save(obj);
	}

	@Override
	public AppraisalForms update(AppraisalForms obj) {
		return objDAO.update(obj);
	}

	@Override
	public void delete(Long id) {
		objDAO.delete(id);
	}

}
