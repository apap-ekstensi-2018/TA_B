package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.DosenDAO;
import com.example.model.DosenModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class DosenServiceRest implements DosenService {
	
	@Autowired
	DosenDAO dosenDAO;
	
	@Override
	public DosenModel selectDosenById(int id) {
		log.info ("REST - select Dosen with id {}", id);
		return dosenDAO.selectDosenById(id);
	}

}
