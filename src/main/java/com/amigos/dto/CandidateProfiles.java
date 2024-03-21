package com.amigos.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = "CandidateProfiles")
public class CandidateProfiles {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "CandidateID")
	private int candidateId;

	@ManyToOne
	@JoinColumn(name = "EmployeeID")
	private Employees employee;

	// Getters and setters
	public CandidateProfiles() {
	}

	public CandidateProfiles(int candidateId, Employees employee) {
		this.candidateId = candidateId;
		this.employee = employee;
	}

	public int getCandidateId() {
		return candidateId;
	}

	public void setCandidateId(int candidateId) {
		this.candidateId = candidateId;
	}

	public Employees getEmployee() {
		return employee;
	}

	public void setEmployee(Employees employee) {
		this.employee = employee;
	}

	@Override
	public String toString() {
		return "CandidateProfiles [candidateId=" + candidateId + ", employee=" + employee + "]";
	}

}