package com.example.controller;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Collection;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.model.UserAccountModel;
import com.example.service.PeminjamanRuanganService;
import com.example.service.UserAccountService;

@Controller
public class PageController {
	
	@Autowired
	UserAccountService userAccountService;
	
	@Autowired
	PeminjamanRuanganService peminjamanRuanganService;
	
	@RequestMapping("/")
	public String index (Model model) {
		UserAccountModel userAccount = userAccountService.selectUserAccount();
		Date date = new Date();
		DateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
		String today_date = dateFormat.format(date);
		int totalPending =  peminjamanRuanganService.quantityTotalStatusPeminjamanPending(today_date);
		
		int totalRuanganNotAvailable = peminjamanRuanganService.quantityToatalRuanganDigunakan(today_date);
		
		//List<int[]> top5Ruangan = peminjamanRuanganService.selectTop5ruangan();
		
		
		//model.addAttribute("top5Ruangan", top5Ruangan);
		model.addAttribute("totalRuanganNotAvailable", totalRuanganNotAvailable);
		model.addAttribute("totalPending", totalPending);
		model.addAttribute("userAccount", userAccount);
		return "index";
	}
	
	@RequestMapping("/login")
	public String login () {
		return "login";
	}
	
	public String getRole(){
        String role = null;
        Object principal = SecurityContextHolder.getContext().getAuthentication().getPrincipal();
        if (principal instanceof UserDetails) {
            Collection<? extends GrantedAuthority> grantedAuthorities = ((UserDetails)principal).getAuthorities();
            for (GrantedAuthority a : grantedAuthorities) {
                role = a.getAuthority();	
            }
        } else {
            role = principal.toString();
        }

        return role;
    }
}
