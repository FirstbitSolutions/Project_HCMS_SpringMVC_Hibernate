package com.amigos.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.amigos.dao.LeaveTypesDAO;
import com.amigos.dto.LeaveTypes;

@Service
public class LeaveTypesServiceImpl implements LeaveTypesService {

	@Autowired
	private LeaveTypesDAO objDAO;

	@Override
	public List<LeaveTypes> getAll() {
		return objDAO.getAll();
	}

	@Override
	public LeaveTypes getLeaveTypesById(Long id) {
		return objDAO.getLeaveTypesById(id);
	}

	@Override
	public Long save(LeaveTypes obj) {
		return objDAO.save(obj);
	}

	@Override
	public LeaveTypes update(LeaveTypes obj) {
		return objDAO.update(obj);
	}

	@Override
	public void delete(Long id) {
		objDAO.delete(id);
	}

}
