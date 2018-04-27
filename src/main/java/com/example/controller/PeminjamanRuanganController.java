package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.model.MahasiswaModel;
import com.example.model.PeminjamanRuanganModel;
import com.example.service.MahasiswaService;
import com.example.service.PeminjamanRuanganService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class PeminjamanRuanganController {
	
	@Autowired
	PeminjamanRuanganService peminjamanRuanganService;
	@Autowired
	MahasiswaService mahasiswaService;
	
	@RequestMapping("/peminjaman/view/{id_peminjaman}")
	public String view(Model model, @PathVariable(value ="id_peminjaman", required = false)String id_peminjaman){
		int idp = Integer.parseInt(id_peminjaman);
		PeminjamanRuanganModel peminjamanruang = peminjamanRuanganService.selectPeminjamanRuangan(idp);
		if (peminjamanruang != null) {
			MahasiswaModel mahasiswa= mahasiswaService.selectMahasiswaById(peminjamanruang.getId_mahasiswa());
            model.addAttribute ("peminjamanruang", peminjamanruang);
            model.addAttribute("mahasiswa", mahasiswa);
            return "view-peminjaman-budi"; //buat html
        } else {
        		model.addAttribute ("id_peminjaman", id_peminjaman);
            return "not-found";
        }
	}	
	
	@RequestMapping("/peminjaman/viewall")
	public String viewAll(Model model)
    {
        List<PeminjamanRuanganModel> peminjamanruang = peminjamanRuanganService.selectAllPeminjamanRuangan();
        //PeminjamanRuanganModel peminjamanr = peminjamanRuanganService.selectIdPeminjamanRuangans();
        //MahasiswaModel mahasiswa = mahasiswaService.selectMahasiswaById(peminjamanr.getId_mahasiswa());
        //MahasiswaModel mahasiswa = mahasiswaService.selectMahasiswaById(peminjamanruang.);
        model.addAttribute ("peminjamanruang", peminjamanruang);
        //model.addAttribute("mahasiswa", mahasiswa);

        return "viewall-history-peminjaman";
        //buat html 
    }
	
	@RequestMapping("/peminjaman/riwayat")
	public String viewByIdMahasiswa(Model model){
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
