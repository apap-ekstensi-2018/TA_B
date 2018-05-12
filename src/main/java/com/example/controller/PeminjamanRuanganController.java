package com.example.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.dto.PeminjamanRuanganDTO;
import com.example.model.MahasiswaModel;
import com.example.model.PegawaiModel;
import com.example.model.PeminjamanRuanganModel;
import com.example.model.RuanganModel;
import com.example.model.UserAccountModel;
import com.example.service.MahasiswaService;
import com.example.service.PegawaiService;

import com.example.service.PeminjamanRuanganService;
import com.example.service.RuanganService;
import com.example.service.UserAccountService;

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
	
	@Autowired
	UserAccountService userAccountService;
		
	@RequestMapping("/peminjaman/view/{id_peminjaman}")
	public String view(Model model, @PathVariable(value ="id_peminjaman", required = false)String id_peminjaman){
		UserAccountModel userAccount = userAccountService.selectUserAccount();
		model.addAttribute("userAccount", userAccount);
		int idp = Integer.parseInt(id_peminjaman);
		PeminjamanRuanganModel peminjamanruang = peminjamanRuanganService.selectPeminjamanRuangan(idp);
		if (peminjamanruang != null) {
			MahasiswaModel mahasiswa= mahasiswaService.selectMahasiswaById(peminjamanruang.getId_mahasiswa());
			RuanganModel ruangan = ruanganService.selectRuangan(peminjamanruang.getId_ruang());
			PegawaiModel pegawai = new PegawaiModel();
			
			if(peminjamanruang.getDisetujui_oleh() != 0){
				pegawai = pegawaiService.selectPegawaiById(peminjamanruang.getDisetujui_oleh());
        	}
			
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
		UserAccountModel userAccount = userAccountService.selectUserAccount();
		model.addAttribute("userAccount", userAccount);
        List<PeminjamanRuanganModel> peminjamanruangList = peminjamanRuanganService.selectAllPeminjamanRuangan();
        List<PeminjamanRuanganDTO> peminjamanRuanganDTOList = new ArrayList<>();
        
        for (PeminjamanRuanganModel peminjamanRuangan : peminjamanruangList) {
        	MahasiswaModel mahasiswa = mahasiswaService.selectMahasiswaById(peminjamanRuangan.getId_mahasiswa());
        	RuanganModel ruangan = ruanganService.selectRuangan(peminjamanRuangan.getId_ruang());
        	
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
        	
        	if(peminjamanRuangan.getDisetujui_oleh() == 0){
        		peminjamanRuanganDTO.setDisetujui_oleh("");
        	} else {
        		PegawaiModel pegawai = pegawaiService.selectPegawaiById(peminjamanRuangan.getDisetujui_oleh());
        		peminjamanRuanganDTO.setDisetujui_oleh(pegawai.getNama());
        	}
        	
        	peminjamanRuanganDTOList.add(peminjamanRuanganDTO);
        }
        
        model.addAttribute ("peminjamanruang", peminjamanRuanganDTOList);
        //model.addAttribute("mahasiswa", mahasiswa);

        return "viewall-history-peminjaman";
        //buat html 
    }
	
	@RequestMapping("/peminjaman/riwayat/{npm}")
	public String viewByIdMahasiswa(Model model, @PathVariable(value ="npm", required = false)String npm){
		//int idm = Integer.parseInt(npm);
		UserAccountModel userAccount = userAccountService.selectUserAccount();
		model.addAttribute("userAccount", userAccount);
		MahasiswaModel mahasiswapjm = mahasiswaService.selectMahasiswaByNpm(npm);
		List<PeminjamanRuanganModel> peminjamanruangList = peminjamanRuanganService.selectAllPeminjamanRuanganByIdMahasiswa(mahasiswapjm.getId());
		List<PeminjamanRuanganDTO> peminjamanRuanganDTOList = new ArrayList<>();
		
		for (PeminjamanRuanganModel peminjamanRuangan : peminjamanruangList ) {
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
		
		model.addAttribute("peminjamanruangList", peminjamanRuanganDTOList);
		model.addAttribute("mahasiswa", mahasiswapjm);
		return "viewall-history-Saya";
	}
	
	@RequestMapping("/peminjaman/tambah")
	public String add(@ModelAttribute("peminjamanruang") PeminjamanRuanganModel peminjamanruang, Model model){
		UserAccountModel userAccount = userAccountService.selectUserAccount();
		model.addAttribute("userAccount", userAccount);
		if(peminjamanruang.getId_ruang() ==  0){
			List<RuanganModel> ruangan = ruanganService.selectAllRuangans();
			model.addAttribute("ruangan", ruangan);
			return "add-peminjaman-form";
		} else {
			if(peminjamanRuanganService.checkAvailabilityRuangan(peminjamanruang) > 0) {
				model.addAttribute("statusGagal", "Ruangan telah dipinjam oleh mahasiswa lain");
				return "add-peminjaman-gagal";
			} else {
				RuanganModel ruangan = ruanganService.selectRuangan(peminjamanruang.getId_ruang());
				if(peminjamanruang.getJumlah_peserta() > ruangan.getKapasitas()) {
					model.addAttribute("statusGagal", "Jumlah peserta melebihi kapasitas ruangan");
					return "add-peminjaman-gagal";
				} else if(peminjamanruang.getJumlah_peserta() == 0){
					model.addAttribute("statusGagal", "Jumlah peserta harus diisikan");
					return "add-peminjaman-gagal";
				}else {
					peminjamanruang.setId_mahasiswa(userAccount.getId());
					peminjamanruang.setIs_disetujui("2");
					peminjamanRuanganService.addPeminjamanRuangan(peminjamanruang);
				}
			}
		}
		return "add-peminjaman-sukses";
	}
	
	@RequestMapping("/peminjaman/{id_peminjaman}/konfirmasi")
	public String updateStatus(Model model, @PathVariable(value ="id_peminjaman", required = false)String id_peminjaman, 
			@RequestParam(value = "confirmStatus", required =false) String confirmStatus){
		UserAccountModel userAccount = userAccountService.selectUserAccount();
		model.addAttribute("userAccount", userAccount);
		
		int id = Integer.parseInt(id_peminjaman);
		
		if(confirmStatus.equals("disetujui")){
			peminjamanRuanganService.updateStatusPeminjamanRuangan(id, "1", userAccount.getId());
		} else {
			peminjamanRuanganService.updateStatusPeminjamanRuangan(id, "0", userAccount.getId());
		}		
		return "confirmation-peminjaman-sukses";
	}
	
	@RequestMapping("/peminjaman/tersedia")
	public String cariRuangan (Model model, 
			@RequestParam(value = "tanggal_awal", required =false) String tanggal_awal,
			@RequestParam(value = "waktu_awal", required =false) String waktu_awal,
			@RequestParam(value = "tanggal_akhir", required =false) String tanggal_akhir,
			@RequestParam(value = "waktu_akhir", required =false) String waktu_akhir) 
	{	
		UserAccountModel userAccount = userAccountService.selectUserAccount();
		model.addAttribute("userAccount", userAccount);
		
		if(tanggal_awal==null || tanggal_akhir==null || tanggal_awal=="" || tanggal_akhir=="" ||
				waktu_awal==null || waktu_akhir==null || waktu_awal=="" || waktu_akhir=="") {
				return "cari-ruang-form";
		}else {
			List<RuanganModel> listRuang = ruanganService.selectAllRuangans();

			List<PeminjamanRuanganModel> listBookedRoom = peminjamanRuanganService.selectAllPeminjamanRuanganByDateTime(tanggal_awal, tanggal_akhir, waktu_awal, waktu_akhir);
				
			for (PeminjamanRuanganModel bookedRoom : listBookedRoom) {
				for (RuanganModel ruang : listRuang) {
					if(ruang.getId()==bookedRoom.getId_ruang()) {
						listRuang.remove(ruang);
						break;
					}
				}
			}
		
			
		
			model.addAttribute("ruang", listRuang);
			model.addAttribute("tanggal_awal", tanggal_awal);
			model.addAttribute("waktu_awal", waktu_awal);
			model.addAttribute("tanggal_akhir", tanggal_akhir);
			model.addAttribute("waktu_akhir", waktu_akhir);
			return "viewall-ruangan-kosong";

		}
		
	
	}
	

}
