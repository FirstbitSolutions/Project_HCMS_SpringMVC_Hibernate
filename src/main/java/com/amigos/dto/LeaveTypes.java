package com.amigos.dto;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "LeaveTypes")
public class LeaveTypes {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LeaveTypeID")
	private int leaveTypeId;

	@Column(name = "LeaveTypeName")
	private String leaveTypeName;

	@Column(name = "Description")
	private String description;

	// Getters and setters
	public LeaveTypes() {
		// TODO Auto-generated constructor stub
	}

	public LeaveTypes(int leaveTypeId, String leaveTypeName, String description) {
		super();
		this.leaveTypeId = leaveTypeId;
		this.leaveTypeName = leaveTypeName;
		this.description = description;
	}

	public int getLeaveTypeId() {
		return leaveTypeId;
	}

	public void setLeaveTypeId(int leaveTypeId) {
		this.leaveTypeId = leaveTypeId;
	}

	public String getLeaveTypeName() {
		return leaveTypeName;
	}

	public void setLeaveTypeName(String leaveTypeName) {
		this.leaveTypeName = leaveTypeName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "LeaveTypes [leaveTypeId=" + leaveTypeId + ", leaveTypeName=" + leaveTypeName + ", description="
				+ description + "]";
	}
	
	
}