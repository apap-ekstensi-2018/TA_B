package com.example.dao;

import com.example.model.PegawaiModel;

public interface PegawaiDAO {
	
	PegawaiModel selectPegawaiByNip(String nip);
	
	PegawaiModel selectPegawaiById(int id);

}
