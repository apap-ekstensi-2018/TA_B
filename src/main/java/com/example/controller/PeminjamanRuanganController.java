package com.example.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


import com.example.service.PeminjamanRuanganService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class PeminjamanRuanganController {
	
	@Autowired
	PeminjamanRuanganService peminjamanRuanganService;
	
	@RequestMapping("/peminjaman/view/{id_peminjaman}")
	public String view(){
		// TODO Auto-generated method stub
		return null;
	}
	
	@RequestMapping("/peminjaman/viewall")
	public String viewAll(){
		// TODO Auto-generated method stub
		return null;
	}
	
	@RequestMapping("/peminjaman/riwayat")
	public String viewByIdMahasiswa(){
		// TODO Auto-generated method stub
		return null;
	}
	
	@RequestMapping("/peminjaman/tambah")
	public String add(){
		// TODO Auto-generated method stub
		return null;
	}
	
	@RequestMapping("/peminjaman/{id_peminjaman}/konfirmasi")
	public String updateStatus(){
		// TODO Auto-generated method stub
		return null;
	}
	

}
