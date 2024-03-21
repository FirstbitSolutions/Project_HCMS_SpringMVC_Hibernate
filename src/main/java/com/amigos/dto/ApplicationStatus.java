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
@Table(name = "ApplicationStatus")
public class ApplicationStatus {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "ApplicationID")
	private int applicationId;

	@ManyToOne
	@JoinColumn(name = "CandidateID")
	private CandidateProfiles candidate;

	@ManyToOne
	@JoinColumn(name = "VacancyID")
	private Vacancies vacancies;

	@Column(name = "Status")
	private String status;

	@Column(name = "ApplicationDate")
	private Date applicationDate;

	@Column(name = "ApplicationNotes")
	private String applicationNotes;

	// Getters and setters
	public ApplicationStatus() {
		// TODO Auto-generated constructor stub
	}

	public ApplicationStatus(int applicationId, CandidateProfiles candidate, Vacancies vacancies, String status,
			Date applicationDate, String applicationNotes) {
		super();
		this.applicationId = applicationId;
		this.candidate = candidate;
		this.vacancies = vacancies;
		this.status = status;
		this.applicationDate = applicationDate;
		this.applicationNotes = applicationNotes;
	}

	public int getApplicationId() {
		return applicationId;
	}

	public void setApplicationId(int applicationId) {
		this.applicationId = applicationId;
	}

	public CandidateProfiles getCandidate() {
		return candidate;
	}

	public void setCandidate(CandidateProfiles candidate) {
		this.candidate = candidate;
	}

	public Vacancies getVacancies() {
		return vacancies;
	}

	public void setVacancies(Vacancies vacancies) {
		this.vacancies = vacancies;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public Date getApplicationDate() {
		return applicationDate;
	}

	public void setApplicationDate(Date applicationDate) {
		this.applicationDate = applicationDate;
	}

	public String getApplicationNotes() {
		return applicationNotes;
	}

	public void setApplicationNotes(String applicationNotes) {
		this.applicationNotes = applicationNotes;
	}

	@Override
	public String toString() {
		return "ApplicationStatus [applicationId=" + applicationId + ", candidate=" + candidate + ", vacancies="
				+ vacancies + ", status=" + status + ", applicationDate=" + applicationDate + ", applicationNotes="
				+ applicationNotes + "]";
	}

}