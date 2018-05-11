package com.example.service;

import java.sql.Time;
import java.util.ArrayList;
import java.util.Date;
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
	private PeminjamanRuanganMapper peminjamanRuangMapper;	
	
	@Override
	public PeminjamanRuanganModel selectPeminjamanRuangan(int id_peminjaman) {
		log.info ("select peminjaman with id peminjaman {}",id_peminjaman);
		return peminjamanRuangMapper.selectPeminjamanRuangan(id_peminjaman);
	}

	@Override
	public List<PeminjamanRuanganModel> selectAllPeminjamanRuangan() {
		log.info ("select all peminjaman");
		return peminjamanRuangMapper.selectAllPeminjamanRuangan();
	}

	@Override
	public List<PeminjamanRuanganModel> selectAllPeminjamanRuanganByIdMahasiswa(int id_mahasiswa) {
		log.info ("select all peminjaman by id Mahasiswa");
		return peminjamanRuangMapper.selectAllPeminjamanRuanganByIdMahasiswa(id_mahasiswa);
	}

	@Override
	public void addPeminjamanRuangan(PeminjamanRuanganModel peminjamanRuangan) {
		log.info("add peminjaman ruangan");
		peminjamanRuangMapper.addPeminjamanRuangan(peminjamanRuangan);
		
	}

	@Override
	public void updateStatusPeminjamanRuangan(int id_peminjaman, String status) {
		// TODO Auto-generated method stub
		
	}
	/*
	@Override
	public void selectIdPeminjamanRuangans() {
		// TODO Auto-generated method stub
		log.info ("select all peminjaman");
		peminjamanRuangMapper.selectIdPeminjamanRuangans();
	}*/

	@Override
	public ArrayList<PeminjamanRuanganModel> selectArrayAllPeminjamanRuangan() {
		log.info ("select all peminjaman");
		return peminjamanRuangMapper.selectArrayAllPeminjamanRuangan();
	
	}

	@Override
	public List<PeminjamanRuanganModel> selectAllPeminjamanRuanganByDateTime(String tanggal_mulai, String tanggal_selesai, String waktu_mulai, String waktu_selesai) {
		log.info ("select all peminjaman by date in {}, date out{}, time in {}, timeout {}",tanggal_mulai,tanggal_selesai,waktu_mulai,waktu_selesai);
		return peminjamanRuangMapper.selectAllPeminjamanRuanganByDateTime(tanggal_mulai, tanggal_selesai, waktu_mulai, waktu_selesai);
	}

	@Override
	public int checkAvailabilityRuangan(PeminjamanRuanganModel peminjamanRuangan) {
		log.info("cek daftar peminajaman ruang");
		return peminjamanRuangMapper.checkAvailabilityRuangan(peminjamanRuangan);
	}//	@Override
//	public List<PeminjamanRuanganModel> selectPeminjamanRuanganByNpm(int npm) {
//		//log.info(("select all mahasiswaByNpm");
//		return selectPeminjamanRuanganByNpm(npm);
	//}
	

	
	
}
