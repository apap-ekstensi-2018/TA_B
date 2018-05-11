package com.example.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.example.model.MahasiswaModel;

@Service
public class MahasiswaDAOImpl implements MahasiswaDAO{
	
	@Autowired
	private RestTemplate restTemplate;
	
	@Override
	public MahasiswaModel selectMahasiswaById(int id_mahasiswa) {
		
		MahasiswaModel mahasiswa = restTemplate.getForObject(
				"https://apap-fasilkom.herokuapp.com/api/mahasiswa/view/id/" + id_mahasiswa, MahasiswaModel.class);
		
		return mahasiswa;
	}

	@Override
	public MahasiswaModel selectMahasiswaByNpm(String npm) {
		MahasiswaModel mahasiswa = restTemplate.getForObject(
				"https://apap-fasilkom.herokuapp.com/api/mahasiswa/view/npm/" + npm, MahasiswaModel.class);
		
		return mahasiswa;
	}

}
