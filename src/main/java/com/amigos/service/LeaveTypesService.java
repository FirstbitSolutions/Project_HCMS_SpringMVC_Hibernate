package com.amigos.service;

import java.util.List;

import com.amigos.dto.LeaveTypes;

public interface LeaveTypesService {

	List<LeaveTypes> getAll();

	LeaveTypes getLeaveTypesById(Long id);

	Long save(LeaveTypes obj);

	LeaveTypes update(LeaveTypes obj);

	void delete(Long id);

}