package com.amigos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.PayrollDAO;
import com.amigos.dto.Payroll;

@Service
public class PayrollServiceImpl implements PayrollService {

	@Autowired
	private PayrollDAO objDAO;

	@Override
	public List<Payroll> getAll() {
		return objDAO.getAll();
	}

	@Override
	public Payroll getPayrollById(Long id) {
		return objDAO.getPayrollById(id);
	}

	@Override
	public Long save(Payroll obj) {
		return objDAO.save(obj);
	}

	@Override
	public Payroll update(Payroll obj) {
		return objDAO.update(obj);
	}

	@Override
	public void delete(Long id) {
		objDAO.delete(id);
	}

}
