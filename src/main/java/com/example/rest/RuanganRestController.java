package com.example.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.model.RuanganModel;
import com.example.service.RuanganService;

@RestController
@RequestMapping("/api")
public class RuanganRestController {
	
	@Autowired
	RuanganService ruanganService;
	
	@RequestMapping("/ruang/view/{id}")
	 public RuanganModel view(@PathVariable(value="id") int id)
	{
		RuanganModel ruang = ruanganService.selectRuangan(id);
		return ruang;
	}

}
