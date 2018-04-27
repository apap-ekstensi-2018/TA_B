package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.PeminjamanRuanganMapper;
import com.example.model.PeminjamanRuanganModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class PeminjamanRuanganServiceDatabase implements PeminjamanRuanganService{
	
	@Autowired
	PeminjamanRuanganMapper peminjamanRuanganMapper;

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
	public void addPeminjamanRuangan(PeminjamanRuanganModel peminjamanRuangan) {
		log.info("add peminjaman ruangan");
		peminjamanRuanganMapper.addPeminjamanRuangan(peminjamanRuangan);
		
	}

	@Override
	public void updateStatusPeminjamanRuangan(int id_peminjaman, String status) {
		// TODO Auto-generated method stub
		
	}
	
	
}
