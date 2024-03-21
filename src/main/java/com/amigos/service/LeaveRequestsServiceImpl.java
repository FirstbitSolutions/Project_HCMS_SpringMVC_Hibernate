package com.amigos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.LeaveRequestsDAO;
import com.amigos.dto.LeaveRequests;

@Service
public class LeaveRequestsServiceImpl implements LeaveRequestsService {

	@Autowired
	private LeaveRequestsDAO objDAO;

	@Override
	public List<LeaveRequests> getAll() {
		return objDAO.getAll();
	}

	@Override
	public LeaveRequests getLeaveRequestsById(Long id) {
		return objDAO.getLeaveRequestsById(id);
	}

	@Override
	public Long save(LeaveRequests obj) {
		return objDAO.save(obj);
	}

	@Override
	public void update(LeaveRequests obj) {
		objDAO.update(obj);
	}

	@Override
	public void delete(Long id) {
		objDAO.delete(id);
	}

}
