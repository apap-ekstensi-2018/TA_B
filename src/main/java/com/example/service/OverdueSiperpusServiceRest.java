package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.OverdueSiperpusDAO;
import com.example.model.OverdueSiperpusModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class OverdueSiperpusServiceRest implements OverdueSiperpusService {

	@Autowired
	OverdueSiperpusDAO overdueSiperpusDAO;
	
	@Override
	public OverdueSiperpusModel selectStatusOverdue(String npm) {
		log.info ("REST - select overdue status from siperpus with npm {}", npm);
		return overdueSiperpusDAO.selectStatusOverdue(npm);
	}

}
