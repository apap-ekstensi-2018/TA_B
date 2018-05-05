package com.example.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.dao.RuanganMapper;
import com.example.model.RuanganModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class RuanganServiceDatabase implements RuanganService{
	
	@Autowired
    private RuanganMapper ruanganMapper;

	@Override
	public RuanganModel selectRuangan(int id_ruang) {
			return ruanganMapper.selectRuangan(id_ruang);
	}

	
	@Override
	public RuanganModel selectRuanganByNama(String nama) {
			return ruanganMapper.selectRuanganByNama(nama);
	}
	@Override
	public List<RuanganModel> selectAllRuangans() {
        	return ruanganMapper.selectAllRuangans ();
	}
	

	@Override
	public void addRuangan(RuanganModel ruanganModel) {
			ruanganMapper.addRuangan(ruanganModel);
		
	}

	@Override
	public void updateRuangan(RuanganModel ruanganModel) {
		ruanganMapper.updateRuangan(ruanganModel);
	}

	@Override
	public void deleteRuangan(int id_ruang) {
		// TODO Auto-generated method stub
		
	}

	

}
