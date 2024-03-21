package com.amigos.dao;

import java.util.List;

import com.amigos.dto.LeaveRequests;

public interface LeaveRequestsDAO {

	List<LeaveRequests> getAll();

	LeaveRequests getLeaveRequestsById(Long id);

	Long save(LeaveRequests obj);

	void update(LeaveRequests obj);

	void delete(Long id);

}