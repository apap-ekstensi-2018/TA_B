package com.example.service;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.model.PeminjamanRuanganModel;

public interface PeminjamanRuanganService {
	
	PeminjamanRuanganModel selectPeminjamanRuangan(int id_peminjaman);
	
	List<PeminjamanRuanganModel> selectAllPeminjamanRuangan();
	
	List<PeminjamanRuanganModel> selectAllPeminjamanRuanganByDateTime(String tanggal_mulai, String tanggal_selesai, String waktu_mulai, String waktu_selesai);
	
	ArrayList<PeminjamanRuanganModel> selectArrayAllPeminjamanRuangan();
	
	List<PeminjamanRuanganModel> selectAllPeminjamanRuanganByIdMahasiswa(int id_mahasiswa);
	
	void addPeminjamanRuangan(PeminjamanRuanganModel peminjamanRuangan);
	
	void updateStatusPeminjamanRuangan(int id_peminjaman, String status);
	
	int checkAvailabilityRuangan(PeminjamanRuanganModel peminjamanRuangan);
	
	//void selectIdPeminjamanRuangans ();
	
	//List<PeminjamanRuanganModel> selectPeminjamanRuanganByNpm(int npm);
}
