package com.amigos.dao;

import java.util.List;

import com.amigos.dto.LeaveApprovals;

public interface LeaveApprovalsDAO {

	List<LeaveApprovals> getAll();

	LeaveApprovals getLeaveApprovalsById(Long id);

	Long save(LeaveApprovals obj);

	LeaveApprovals update(LeaveApprovals obj);

	void delete(Long id);

}
