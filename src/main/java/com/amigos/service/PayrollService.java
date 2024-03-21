package com.amigos.service;

import java.util.List;

import com.amigos.dto.Payroll;

public interface PayrollService {

	List<Payroll> getAll();

	Payroll getPayrollById(Long id);

	Long save(Payroll obj);

	Payroll update(Payroll obj);

	void delete(Long id);

}