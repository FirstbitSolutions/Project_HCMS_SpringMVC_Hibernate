
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
@Table(name = "SkillMatrix")
public class SkillMatrix {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "MatrixID")
	private int matrixId;

	@ManyToOne
	@JoinColumn(name = "EmployeeID")
	private Employees employee;

	@Column(name = "SkillName")
	private String skillName;

	@Column(name = "SkillLevel")
	private int skillLevel;

	@Column(name = "LastUpdated")
	private Date lastUpdated;

	// Getters and setters
	public SkillMatrix() {
		// TODO Auto-generated constructor stub
	}

	public SkillMatrix(int matrixId, Employees employee, String skillName, int skillLevel, Date lastUpdated) {
		super();
		this.matrixId = matrixId;
		this.employee = employee;
		this.skillName = skillName;
		this.skillLevel = skillLevel;
		this.lastUpdated = lastUpdated;
	}

	public int getMatrixId() {
		return matrixId;
	}

	public void setMatrixId(int matrixId) {
		this.matrixId = matrixId;
	}

	public Employees getEmployee() {
		return employee;
	}

	public void setEmployee(Employees employee) {
		this.employee = employee;
	}

	public String getSkillName() {
		return skillName;
	}

	public void setSkillName(String skillName) {
		this.skillName = skillName;
	}

	public int getSkillLevel() {
		return skillLevel;
	}

	public void setSkillLevel(int skillLevel) {
		this.skillLevel = skillLevel;
	}

	public Date getLastUpdated() {
		return lastUpdated;
	}

	public void setLastUpdated(Date lastUpdated) {
		this.lastUpdated = lastUpdated;
	}

	@Override
	public String toString() {
		return "SkillMatrix [matrixId=" + matrixId + ", employee=" + employee + ", skillName=" + skillName
				+ ", skillLevel=" + skillLevel + ", lastUpdated=" + lastUpdated + "]";
	}

}
