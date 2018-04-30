package com.example.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.model.DosenModel;


@Service
public class DosenDAOImpl implements DosenDAO {
	
	@Autowired
	private RestTemplate restTemplate;

	@Override
	public DosenModel selectDosenById(int id) {
		DosenModel dosen = restTemplate.getForObject(
				"https://apap-fasilkom.herokuapp.com/api/dosen/view/id/" +id, DosenModel.class);
		return dosen;
	}

}
