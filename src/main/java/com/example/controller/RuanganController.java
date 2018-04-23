package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.service.RuanganService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class RuanganController {

	@Autowired
	RuanganService ruanganService;
	
	@RequestMapping("/ruang/view/{id_ruangan}")
	public String view(){
		// TODO Auto-generated method stub
		return null;
	}
	
	@RequestMapping("/ruang/viewall")
	public String viewAll(){
		// TODO Auto-generated method stub
		return null;
	}
	
	@RequestMapping("/ruang/tambah")
	public String add(){
		// TODO Auto-generated method stub
		return null;
	}
	
	@RequestMapping("/ruang/ubah/{id_ruangan}")
	public String update(){
		// TODO Auto-generated method stub
		return null;
	}
	
	@RequestMapping("​/ruang/hapus/{id_ruangan}")
	public String delete(){
		// TODO Auto-generated method stub
		return null;
	}
	
	
}
