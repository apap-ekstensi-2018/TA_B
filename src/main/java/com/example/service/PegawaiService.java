package com.example.service;

import com.example.model.PegawaiModel;

public interface PegawaiService {
	
	PegawaiModel selectPegawaiByNip(int nip);
	
	PegawaiModel selectPegawaiById(int id);

}
