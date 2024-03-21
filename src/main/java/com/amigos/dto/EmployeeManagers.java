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
@Table(name = "EmployeeManagers")
public class EmployeeManagers {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "RelationshipID")
	private int relationshipId;

	@ManyToOne
	@JoinColumn(name = "EmployeeID")
	private Employees employee;

	@ManyToOne
	@JoinColumn(name = "ManagerID")
	private Employees manager;

	@Column(name = "RelationshipType")
	private String relationshipType;

	// Getters and setters
	public EmployeeManagers() {
	}

	public EmployeeManagers(int relationshipId, Employees employee, Employees manager, String relationshipType) {
		this.relationshipId = relationshipId;
		this.employee = employee;
		this.manager = manager;
		this.relationshipType = relationshipType;
	}

	public int getRelationshipId() {
		return relationshipId;
	}

	public void setRelationshipId(int relationshipId) {
		this.relationshipId = relationshipId;
	}

	public Employees getEmployee() {
		return employee;
	}

	public void setEmployee(Employees employee) {
		this.employee = employee;
	}

	public Employees getManager() {
		return manager;
	}

	public void setManager(Employees manager) {
		this.manager = manager;
	}

	public String getRelationshipType() {
		return relationshipType;
	}

	public void setRelationshipType(String relationshipType) {
		this.relationshipType = relationshipType;
	}

	@Override
	public String toString() {
		return "EmployeeManagers [relationshipId=" + relationshipId + ", employee=" + employee + ", manager=" + manager
				+ ", relationshipType=" + relationshipType + "]";
	}

}