package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.RuanganModel;
import com.example.service.RuanganService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class RuanganController {

	@Autowired
	RuanganService ruanganService;
	
	@RequestMapping("/ruang/view/{id_ruangan}")
	public String view(Model model,
				@PathVariable(value = "id_ruangan", required = false) int id)
		{
			
			RuanganModel ruangan = ruanganService.selectRuangan(id);
			
			if(ruangan != null) {
				model.addAttribute("ruangan", ruangan);
				return "view-ruangan";
			}
			else {
				model.addAttribute("id_ruangan", id);
				
	            return "not-found";
			}
			
		}
		
	
	@RequestMapping("/ruang/viewall")
	public String viewAll(Model model){
	        List<RuanganModel> ruangans = ruanganService.selectAllRuangans();
	        model.addAttribute ("ruangans", ruangans);

	        return "viewall-ruangan";
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
