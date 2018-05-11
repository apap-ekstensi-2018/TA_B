package com.example.service;

import com.example.model.PegawaiModel;

public interface PegawaiService {
	
	PegawaiModel selectPegawaiByNip(String nip);
	
	PegawaiModel selectPegawaiById(int id);

}
