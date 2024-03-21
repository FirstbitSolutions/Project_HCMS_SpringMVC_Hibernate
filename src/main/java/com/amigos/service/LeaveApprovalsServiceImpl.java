package com.amigos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.LeaveApprovalsDAO;
import com.amigos.dto.LeaveApprovals;

@Service
public class LeaveApprovalsServiceImpl implements LeaveApprovalsService {

	@Autowired
	private LeaveApprovalsDAO objDAO;

	@Override
	public List<LeaveApprovals> getAll() {
		return objDAO.getAll();
	}

	@Override
	public LeaveApprovals getLeaveApprovalsById(Long id) {
		return objDAO.getLeaveApprovalsById(id);
	}

	@Override
	public Long save(LeaveApprovals obj) {
		return objDAO.save(obj);
	}

	@Override
	public LeaveApprovals update(LeaveApprovals obj) {
		return objDAO.update(obj);
	}

	@Override
	public void delete(Long id) {
		objDAO.delete(id);
	}

}
