package com.example.service;

import java.util.List;

import com.example.model.PeminjamanRuanganModel;

public interface PeminjamanRuanganService {
	
	PeminjamanRuanganModel selectPeminjamanRuangan(int id_peminjaman);
	
	List<PeminjamanRuanganModel> selectAllPeminjamanRuangan();
	
	List<PeminjamanRuanganModel> selectAllPeminjamanRuanganByIdMahasiswa(int id_mahasiswa);
	
	void addPeminjamanRuangan(PeminjamanRuanganModel peminjamanRuangan);
	
	void updateStatusPeminjamanRuangan(int id_peminjaman, String status);
}
