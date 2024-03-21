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
@Table(name = "LeaveRequests")
public class LeaveRequests {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "LeaveRequestID")
	private int leaveRequestId;

	@ManyToOne
	@JoinColumn(name = "EmployeeID")
	private Employees employee;

	@ManyToOne
	@JoinColumn(name = "LeaveType")
	private LeaveTypes leaveType;

	@Column(name = "StartDate")
	private Date startDate;

	@Column(name = "EndDate")
	private Date endDate;

	@Column(name = "LeaveReason")
	private String leaveReason;

	@Column(name = "Status")
	private String status;

	// Getters and setters
	public LeaveRequests() {
		// TODO Auto-generated constructor stub
	}

	public LeaveRequests(int leaveRequestId, Employees employee, LeaveTypes leaveType, Date startDate,
			Date endDate, String leaveReason, String status) {
		super();
		this.leaveRequestId = leaveRequestId;
		this.employee = employee;
		this.leaveType = leaveType;
		this.startDate = startDate;
		this.endDate = endDate;
		this.leaveReason = leaveReason;
		this.status = status;
	}

	public int getLeaveRequestId() {
		return leaveRequestId;
	}

	public void setLeaveRequestId(int leaveRequestId) {
		this.leaveRequestId = leaveRequestId;
	}

	public Employees getEmployee() {
		return employee;
	}

	public void setEmployee(Employees employee) {
		this.employee = employee;
	}

	public LeaveTypes getLeaveType() {
		return leaveType;
	}

	public void setLeaveType(LeaveTypes leaveType) {
		this.leaveType = leaveType;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public String getLeaveReason() {
		return leaveReason;
	}

	public void setLeaveReason(String leaveReason) {
		this.leaveReason = leaveReason;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Override
	public String toString() {
		return "LeaveRequests [leaveRequestId=" + leaveRequestId + ", employee=" + employee + ", leaveType=" + leaveType
				+ ", startDate=" + startDate + ", endDate=" + endDate + ", leaveReason=" + leaveReason + ", status="
				+ status + "]";
	}

}
