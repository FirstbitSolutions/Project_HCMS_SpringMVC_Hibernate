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
@Table(name = "Vacancies")
public class Vacancies {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "VacancyID")
	private int vacancyId;

	@ManyToOne
	@JoinColumn(name = "DepartmentID")
	private Departments department;

	@Column(name = "Position")
	private String position;

	@Column(name = "RequiredSkillSet")
	private String requiredSkillSet;

	@Column(name = "NumberOfOpenings")
	private int numberOfOpenings;

	// Getters and setters
	public Vacancies() {
		// TODO Auto-generated constructor stub
	}

	public Vacancies(int vacancyId, Departments department, String position, String requiredSkillSet,
			int numberOfOpenings) {
		super();
		this.vacancyId = vacancyId;
		this.department = department;
		this.position = position;
		this.requiredSkillSet = requiredSkillSet;
		this.numberOfOpenings = numberOfOpenings;
	}

	public int getVacancyId() {
		return vacancyId;
	}

	public void setVacancyId(int vacancyId) {
		this.vacancyId = vacancyId;
	}

	public Departments getDepartment() {
		return department;
	}

	public void setDepartment(Departments department) {
		this.department = department;
	}

	public String getPosition() {
		return position;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getRequiredSkillSet() {
		return requiredSkillSet;
	}

	public void setRequiredSkillSet(String requiredSkillSet) {
		this.requiredSkillSet = requiredSkillSet;
	}

	public int getNumberOfOpenings() {
		return numberOfOpenings;
	}

	public void setNumberOfOpenings(int numberOfOpenings) {
		this.numberOfOpenings = numberOfOpenings;
	}

	@Override
	public String toString() {
		return "Vacancies [vacancyId=" + vacancyId + ", department=" + department + ", position=" + position
				+ ", requiredSkillSet=" + requiredSkillSet + ", numberOfOpenings=" + numberOfOpenings + "]";
	}

}