package com.example.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.PegawaiDAO;
import com.example.model.PegawaiModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PegawaiServiceRest implements PegawaiService{

	@Autowired
	PegawaiDAO pegawaiDAO;
	
	@Override
	public PegawaiModel selectPegawaiByNip(int nip) {
		log.info ("REST - select Pegawai with nip {}", nip);
		return pegawaiDAO.selectPegawaiByNip(nip);
	}

}
