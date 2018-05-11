package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.MahasiswaDAO;
import com.example.model.MahasiswaModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class MahasiswaServiceRest implements MahasiswaService{
	
	@Autowired
	MahasiswaDAO mahasiswaDAO;

	@Override
	public MahasiswaModel selectMahasiswaById(int id_mahasiswa) {
		log.info ("REST - select mahasiswa with id {}", id_mahasiswa);
		return mahasiswaDAO.selectMahasiswaById(id_mahasiswa);
	}

	@Override
	public MahasiswaModel selectMahasiswaByNpm(String npm) {
		log.info ("REST - select mahasiswa with npm {}", npm);
		return mahasiswaDAO.selectMahasiswaByNpm(npm);
	}

}
