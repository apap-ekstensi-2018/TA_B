package com.example.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.RuanganModel;
import com.example.model.UserAccountModel;
import com.example.service.RuanganService;
import com.example.service.UserAccountService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class RuanganController {

	@Autowired
	RuanganService ruanganService;
	
	@Autowired
	UserAccountService userAccountService;
	
	@RequestMapping("/ruang/view/{id_ruangan}")
	public String view(Model model,
				@PathVariable(value = "id_ruangan", required = false) int id)
		{
			UserAccountModel userAccount = userAccountService.selectUserAccount();
			model.addAttribute("userAccount", userAccount);
			
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
			UserAccountModel userAccount = userAccountService.selectUserAccount();
			model.addAttribute("userAccount", userAccount);
			
	        List<RuanganModel> ruangans = ruanganService.selectAllRuangans();
	        model.addAttribute ("ruangans", ruangans);

	        return "viewall-ruangan";
	}
	
	
	@RequestMapping("/ruang/tambah")
	public String add(@ModelAttribute("ruang") RuanganModel ruanganModel, Model model){
		UserAccountModel userAccount = userAccountService.selectUserAccount();
		model.addAttribute("userAccount", userAccount);
		
		if (ruanganModel.getNama() == null) {
			return "add-ruang-form";
		} else {
			ruanganService.addRuangan(ruanganModel);
			//cek sudah masuk apa belum
			RuanganModel existing = ruanganService.selectRuanganByNama(ruanganModel.getNama());
			if (ruanganModel.getNama().equals(existing.getNama())) {
				return "add-ruang-sukses";
			} else {
				return "add-ruang-gagal";
			}
		}
		
	}
	
	@RequestMapping("/ruang/ubah/{id_ruangan}")
	public String update(@PathVariable(value="id_ruangan") String id_ruangan, Model model, @ModelAttribute("ruang") RuanganModel ruanganModel){
		UserAccountModel userAccount = userAccountService.selectUserAccount();
		model.addAttribute("userAccount", userAccount);
		
		int idr = Integer.parseInt(id_ruangan);
		RuanganModel extRuang = ruanganService.selectRuangan(idr);
		
		if(ruanganModel.getNama()==null) {
			if(extRuang == null) {
				return "ruang-not-found";
			}else {
				model.addAttribute("ruang", extRuang);
				return "update-ruang-form";
			}
		}else {
			ruanganService.updateRuangan(ruanganModel);
			//return "update-ruang-sukses";
			RuanganModel existing = ruanganService.selectRuanganByNama(ruanganModel.getNama());
			if (ruanganModel.getNama().equals(existing.getNama())) {
				return "update-ruang-sukses";
			} else {
				return "update-ruang-gagal";
			}
		}
	}
	
	@RequestMapping("/ruang/hapus/{id_ruangan}")
	//@ResponseBody
	public String delete(RuanganModel ruanganModel, @PathVariable(value="id_ruangan") String id_ruangan, Model model) {
		UserAccountModel userAccount = userAccountService.selectUserAccount();
		model.addAttribute("userAccount", userAccount);
		
		int idruang = Integer.parseInt(id_ruangan);
		RuanganModel existingRuang = ruanganService.selectRuangan(idruang);
		
		if (existingRuang != null) {
			ruanganService.deleteRuangan(idruang);
    		return "delete-ruang-sukses";
    	}else {
            return "ruang-not-found";
    	}
	}
	
//	@RequestMapping("​/ruang/hapus/{id_ruangan}")
//	public String delete(RuanganModel ruanganModel, @PathVariable(value = "id_ruangan") String id_ruangan)
//	{
//		int idruang = Integer.parseInt(id_ruangan);
//		RuanganModel existingRuang = ruanganService.selectRuangan(idruang);
//		
//		if (existingRuang != null) {
//			ruanganService.deleteRuangan(ruanganModel);
//    		return "delete-ruang-sukses";
//    	}else {
//            return "ruang-not-found";
//    	}
//	}
		
}