package com.amigos.service;

import java.util.List;

import com.amigos.dto.LeaveRequests;

public interface LeaveRequestsService {

	List<LeaveRequests> getAll();

	LeaveRequests getLeaveRequestsById(Long id);

	Long save(LeaveRequests obj);

	void update(LeaveRequests obj);

	void delete(Long id);

}