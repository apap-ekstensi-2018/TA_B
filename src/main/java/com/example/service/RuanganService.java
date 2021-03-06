package com.example.service;

import java.util.List;

import com.example.model.RuanganModel;

public interface RuanganService {

	RuanganModel selectRuangan(int id);
	
	RuanganModel selectRuanganByNama (String nama);
	
	RuanganModel selectRuanganByNamaByNotId(String nama, int id);
	
	List<RuanganModel> selectAllRuangans();
	
	void addRuangan(RuanganModel ruanganModel);
	
	void updateRuangan(RuanganModel ruanganModel);
	
	void deleteRuangan(RuanganModel ruanganModel);
	
	void deleteRuangan(int id_ruangan);
	
	int countAllRuang();
}
