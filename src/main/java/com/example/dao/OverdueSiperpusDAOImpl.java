package com.example.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.model.OverdueSiperpusModel;

@Service
public class OverdueSiperpusDAOImpl implements OverdueSiperpusDAO{
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public OverdueSiperpusModel selectStatusOverdue(String npm) {

		OverdueSiperpusModel overdueSiperpus = restTemplate.getForObject(
				"https://kelompok-d-producer.herokuapp.com/siperpus/api/v1/isOverdue/" + npm, OverdueSiperpusModel.class);
		return overdueSiperpus;
	}

}
