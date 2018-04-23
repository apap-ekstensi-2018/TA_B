package com.example.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.model.RuanganModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RuanganServiceDatabase implements RuanganService{

	@Override
	public RuanganModel selectRuangan(int id_ruangan) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<RuanganModel> selectAllRuangans() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void addRuangan(RuanganModel ruanganModel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateRuangan(RuanganModel ruanganModel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void deleteRuangan(int id_ruangan) {
		// TODO Auto-generated method stub
		
	}

}
