package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;

<<<<<<< Updated upstream
import com.example.dto.PeminjamanRuanganDTO;
import com.example.model.DosenModel;
import com.example.model.MahasiswaModel;
import com.example.model.PegawaiModel;
import com.example.model.PeminjamanRuanganModel;
import com.example.model.RuanganModel;
import com.example.service.DosenService;
import com.example.service.MahasiswaService;
import com.example.service.PegawaiService;
=======
import com.example.model.DosenModel;
import com.example.model.MahasiswaModel;
import com.example.model.PeminjamanRuanganModel;
import com.example.service.DosenService;
import com.example.service.MahasiswaService;
>>>>>>> Stashed changes
import com.example.service.PeminjamanRuanganService;
import com.example.service.RuanganService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class PeminjamanRuanganController {
	
	@Autowired
	PeminjamanRuanganService peminjamanRuanganService;
	@Autowired
	MahasiswaService mahasiswaService;
	
	@Autowired
	PegawaiService pegawaiService;
	
	@Autowired
	RuanganService ruanganService;
		
	@RequestMapping("/peminjaman/view/{id_peminjaman}")
	public String view(Model model, @PathVariable(value ="id_peminjaman", required = false)String id_peminjaman){
		int idp = Integer.parseInt(id_peminjaman);
		PeminjamanRuanganModel peminjamanruang = peminjamanRuanganService.selectPeminjamanRuangan(idp);
		if (peminjamanruang != null) {
			MahasiswaModel mahasiswa= mahasiswaService.selectMahasiswaById(peminjamanruang.getId_mahasiswa());
			PegawaiModel pegawai = pegawaiService.selectPegawaiById(peminjamanruang.getDisetujui_oleh());
			RuanganModel ruangan = ruanganService.selectRuangan(peminjamanruang.getId_ruang());
			
            model.addAttribute ("peminjamanruang", peminjamanruang);
            model.addAttribute("ruangan", ruangan);
            model.addAttribute("mahasiswa", mahasiswa);
            model.addAttribute("pegawai", pegawai);
            return "view-peminjaman"; //buat html
        } else {
        		model.addAttribute ("id_peminjaman", id_peminjaman);
            return "not-found";
        }
	}	
	
	@RequestMapping("/peminjaman/viewall")
	public String viewAll(Model model)
    {
<<<<<<< Updated upstream
        List<PeminjamanRuanganModel> peminjamanruangList = peminjamanRuanganService.selectAllPeminjamanRuangan();
        List<PeminjamanRuanganDTO> peminjamanRuanganDTOList = new ArrayList<>();
        
        for (PeminjamanRuanganModel peminjamanRuangan : peminjamanruangList) {
        	MahasiswaModel mahasiswa = mahasiswaService.selectMahasiswaById(peminjamanRuangan.getId_mahasiswa());
        	RuanganModel ruangan = ruanganService.selectRuangan(peminjamanRuangan.getId_ruang());
        	PegawaiModel pegawai = pegawaiService.selectPegawaiById(peminjamanRuangan.getDisetujui_oleh());
        	
        	PeminjamanRuanganDTO peminjamanRuanganDTO = new PeminjamanRuanganDTO();
        	peminjamanRuanganDTO.setId(peminjamanRuangan.getId());
        	peminjamanRuanganDTO.setRuangan(ruangan.getNama());
        	peminjamanRuanganDTO.setNpm_mahasiswa(mahasiswa.getNpm());
        	peminjamanRuanganDTO.setNama_mahasiswa(mahasiswa.getNama());
        	peminjamanRuanganDTO.setWaktu_mulai(peminjamanRuangan.getWaktu_mulai());
        	peminjamanRuanganDTO.setWaktu_selesai(peminjamanRuangan.getWaktu_selesai());
        	peminjamanRuanganDTO.setTanggal_mulai(peminjamanRuangan.getTanggal_mulai());
        	peminjamanRuanganDTO.setTanggal_selesai(peminjamanRuangan.getTanggal_selesai());
        	peminjamanRuanganDTO.setTujuan(peminjamanRuangan.getTujuan());
        	peminjamanRuanganDTO.setKeterangan(peminjamanRuangan.getKeterangan());
        	peminjamanRuanganDTO.setJumlah_peserta(peminjamanRuangan.getJumlah_peserta());
        	peminjamanRuanganDTO.setFasilitas(peminjamanRuangan.getFasilitas());
        	peminjamanRuanganDTO.setIs_disetujui(peminjamanRuangan.getIs_disetujui());
        	peminjamanRuanganDTO.setDisetujui_oleh(pegawai.getNama());
        	
        	peminjamanRuanganDTOList.add(peminjamanRuanganDTO);
        }
        
        
        model.addAttribute ("peminjamanruang", peminjamanRuanganDTOList);
=======
        List<PeminjamanRuanganModel> peminjamanruang = peminjamanRuanganService.selectAllPeminjamanRuangan();
        //ArrayList<PeminjamanRuanganModel> arrpeminjamanruang = peminjamanRuanganService.selectArrayAllPeminjamanRuangan();
        //MahasiswaModel mahasiswa = mahasiswaService.selectMahasiswaById(arrpeminjamanruang.get(2));
        //PeminjamanRuanganModel peminjamanr = peminjamanRuanganService.selectIdPeminjamanRuangans();
        //MahasiswaModel mahasiswa = mahasiswaService.selectMahasiswaById(peminjamanr.getId_mahasiswa());
        //MahasiswaModel mahasiswa = mahasiswaService.selectMahasiswaById(peminjamanruang.ge);
        model.addAttribute ("peminjamanruang", peminjamanruang);
>>>>>>> Stashed changes
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
