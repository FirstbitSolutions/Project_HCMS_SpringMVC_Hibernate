package com.amigos.dto;

import java.math.BigDecimal;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "EducationDetails")
public class EducationDetails {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "EducationID")
	private int educationId;

	@ManyToOne
	@JoinColumn(name = "EmployeeID")
	private Employees employee;

	@Column(name = "Degree")
	private String degree;

	@Column(name = "Institute")
	private String institute;

	@Column(name = "Major")
	private String major;

	@Column(name = "GraduationYear")
	private int graduationYear;

	@Column(name = "GPA")
	private BigDecimal gpa;

	// Getters and setters
	public EducationDetails() {
	}

	public EducationDetails(int educationId, Employees employee, String degree, String institute, String major,
			int graduationYear, BigDecimal gpa) {
		this.educationId = educationId;
		this.employee = employee;
		this.degree = degree;
		this.institute = institute;
		this.major = major;
		this.graduationYear = graduationYear;
		this.gpa = gpa;
	}

	public int getEducationId() {
		return educationId;
	}

	public void setEducationId(int educationId) {
		this.educationId = educationId;
	}

	public Employees getEmployee() {
		return employee;
	}

	public void setEmployee(Employees employee) {
		this.employee = employee;
	}

	public String getDegree() {
		return degree;
	}

	public void setDegree(String degree) {
		this.degree = degree;
	}

	public String getInstitute() {
		return institute;
	}

	public void setInstitute(String institute) {
		this.institute = institute;
	}

	public String getMajor() {
		return major;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public int getGraduationYear() {
		return graduationYear;
	}

	public void setGraduationYear(int graduationYear) {
		this.graduationYear = graduationYear;
	}

	public BigDecimal getGpa() {
		return gpa;
	}

	public void setGpa(BigDecimal gpa) {
		this.gpa = gpa;
	}

	@Override
	public String toString() {
		return "EducationDetails [educationId=" + educationId + ", employee=" + employee + ", degree=" + degree
				+ ", institute=" + institute + ", major=" + major + ", graduationYear=" + graduationYear + ", gpa="
				+ gpa + "]";
	}

}