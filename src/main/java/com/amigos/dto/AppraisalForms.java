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
@Table(name = "AppraisalForms")
public class AppraisalForms {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "FormID")
	private int formId;

	@ManyToOne
	@JoinColumn(name = "EmployeeID")
	private Employees employee;

	@Column(name = "SubmissionDate")
	private Date submissionDate;

	// other fields...

	@ManyToOne
	@JoinColumn(name = "ReviewerID")
	private Employees reviewer;

	// Getters and setters
	public AppraisalForms() {
	}

	public AppraisalForms(int formId, Employees employee, Date submissionDate, Employees reviewer) {
		this.formId = formId;
		this.employee = employee;
		this.submissionDate = submissionDate;
		this.reviewer = reviewer;
	}

	public int getFormId() {
		return formId;
	}

	public void setFormId(int formId) {
		this.formId = formId;
	}

	public Employees getEmployee() {
		return employee;
	}

	public void setEmployee(Employees employee) {
		this.employee = employee;
	}

	public Date getSubmissionDate() {
		return submissionDate;
	}

	public void setSubmissionDate(Date submissionDate) {
		this.submissionDate = submissionDate;
	}

	public Employees getReviewer() {
		return reviewer;
	}

	public void setReviewer(Employees reviewer) {
		this.reviewer = reviewer;
	}

	@Override
	public String toString() {
		return "AppraisalForms [formId=" + formId + ", employee=" + employee + ", submissionDate=" + submissionDate
				+ ", reviewer=" + reviewer + "]";
	}

}
