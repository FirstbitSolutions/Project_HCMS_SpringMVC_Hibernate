package com.amigos.dto;

import java.math.BigDecimal;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "Payroll")
public class Payroll {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "PayrollID")
	private int payrollId;

	@ManyToOne
	@JoinColumn(name = "EmployeeID")
	private Employees employee;

	@Column(name = "SalaryMonth")
	private String salaryMonth;

	@Column(name = "SalaryYear")
	private int salaryYear;

	@Column(name = "BasicSalary")
	private BigDecimal basicSalary;

	@Column(name = "Allowances")
	private BigDecimal allowances;

	@Column(name = "Deductions")
	private BigDecimal deductions;

	@Column(name = "NetSalary")
	private BigDecimal netSalary;

	@Column(name = "PaymentDate")
	private Date paymentDate;

	// Getters and setters
	public Payroll() {
		// TODO Auto-generated constructor stub
	}

	public Payroll(int payrollId, Employees employee, String salaryMonth, int salaryYear, BigDecimal basicSalary,
			BigDecimal allowances, BigDecimal deductions, BigDecimal netSalary, Date paymentDate) {
		super();
		this.payrollId = payrollId;
		this.employee = employee;
		this.salaryMonth = salaryMonth;
		this.salaryYear = salaryYear;
		this.basicSalary = basicSalary;
		this.allowances = allowances;
		this.deductions = deductions;
		this.netSalary = netSalary;
		this.paymentDate = paymentDate;
	}

	public int getPayrollId() {
		return payrollId;
	}

	public void setPayrollId(int payrollId) {
		this.payrollId = payrollId;
	}

	public Employees getEmployee() {
		return employee;
	}

	public void setEmployee(Employees employee) {
		this.employee = employee;
	}

	public String getSalaryMonth() {
		return salaryMonth;
	}

	public void setSalaryMonth(String salaryMonth) {
		this.salaryMonth = salaryMonth;
	}

	public int getSalaryYear() {
		return salaryYear;
	}

	public void setSalaryYear(int salaryYear) {
		this.salaryYear = salaryYear;
	}

	public BigDecimal getBasicSalary() {
		return basicSalary;
	}

	public void setBasicSalary(BigDecimal basicSalary) {
		this.basicSalary = basicSalary;
	}

	public BigDecimal getAllowances() {
		return allowances;
	}

	public void setAllowances(BigDecimal allowances) {
		this.allowances = allowances;
	}

	public BigDecimal getDeductions() {
		return deductions;
	}

	public void setDeductions(BigDecimal deductions) {
		this.deductions = deductions;
	}

	public BigDecimal getNetSalary() {
		return netSalary;
	}

	public void setNetSalary(BigDecimal netSalary) {
		this.netSalary = netSalary;
	}

	public Date getPaymentDate() {
		return paymentDate;
	}

	public void setPaymentDate(Date paymentDate) {
		this.paymentDate = paymentDate;
	}

	@Override
	public String toString() {
		return "Payroll [payrollId=" + payrollId + ", employee=" + employee + ", salaryMonth=" + salaryMonth
				+ ", salaryYear=" + salaryYear + ", basicSalary=" + basicSalary + ", allowances=" + allowances
				+ ", deductions=" + deductions + ", netSalary=" + netSalary + ", paymentDate=" + paymentDate + "]";
	}

}