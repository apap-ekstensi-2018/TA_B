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
	public List<RuanganModel> selectAllRuangans() {
        return ruanganMapper.selectAllRuangans ();
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
	public void deleteRuangan(int id_ruang) {
		// TODO Auto-generated method stub
		
	}

	

}
