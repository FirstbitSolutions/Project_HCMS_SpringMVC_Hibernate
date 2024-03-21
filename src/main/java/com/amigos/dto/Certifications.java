package com.amigos.dto;

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
@Table(name = "Certifications")
public class Certifications {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CertificationID")
	private int certificationId;

	@ManyToOne
	@JoinColumn(name = "EmployeeID")
	private Employees employee;

	@Column(name = "CertificationName")
	private String certificationName;

	@Column(name = "CertificationAuthority")
	private String certificationAuthority;

	@Column(name = "IssueDate")
	private Date issueDate;

	@Column(name = "ExpiryDate")
	private Date expiryDate;

	// Getters and setters
	public Certifications() {
	}

	public Certifications(int certificationId, Employees employee, String certificationName,
			String certificationAuthority, Date issueDate, Date expiryDate) {
		this.certificationId = certificationId;
		this.employee = employee;
		this.certificationName = certificationName;
		this.certificationAuthority = certificationAuthority;
		this.issueDate = issueDate;
		this.expiryDate = expiryDate;
	}

	public int getCertificationId() {
		return certificationId;
	}

	public void setCertificationId(int certificationId) {
		this.certificationId = certificationId;
	}

	public Employees getEmployee() {
		return employee;
	}

	public void setEmployee(Employees employee) {
		this.employee = employee;
	}

	public String getCertificationName() {
		return certificationName;
	}

	public void setCertificationName(String certificationName) {
		this.certificationName = certificationName;
	}

	public String getCertificationAuthority() {
		return certificationAuthority;
	}

	public void setCertificationAuthority(String certificationAuthority) {
		this.certificationAuthority = certificationAuthority;
	}

	public Date getIssueDate() {
		return issueDate;
	}

	public void setIssueDate(Date issueDate) {
		this.issueDate = issueDate;
	}

	public Date getExpiryDate() {
		return expiryDate;
	}

	public void setExpiryDate(Date expiryDate) {
		this.expiryDate = expiryDate;
	}

	@Override
	public String toString() {
		return "Certifications [certificationId=" + certificationId + ", employee=" + employee + ", certificationName="
				+ certificationName + ", certificationAuthority=" + certificationAuthority + ", issueDate=" + issueDate
				+ ", expiryDate=" + expiryDate + "]";
	}

}