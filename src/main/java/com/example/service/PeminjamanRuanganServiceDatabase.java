package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.PeminjamanRuanganModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PeminjamanRuanganServiceDatabase implements PeminjamanRuanganService{

	@Override
	public PeminjamanRuanganModel selectPeminjamanRuangan(int id_peminjaman) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PeminjamanRuanganModel> selectAllPeminjamanRuangan() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<PeminjamanRuanganModel> selectAllPeminjamanRuanganByIdMahasiswa(int id_mahasiswa) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addPeminjamanRuangan(PeminjamanRuanganModel peminjamanRuanganModel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateStatusPeminjamanRuangan(int id_peminjaman, String status) {
		// TODO Auto-generated method stub
		
	}
	
	
}
