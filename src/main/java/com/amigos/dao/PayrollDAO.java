package com.amigos.dao;

import java.util.List;

import com.amigos.dto.Payroll;

public interface PayrollDAO {

	List<Payroll> getAll();

	Payroll getPayrollById(Long id);

	Long save(Payroll obj);

	Payroll update(Payroll obj);

	void delete(Long id);

}