package com.example.controller;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class PageController {
	
	@RequestMapping("/")
	public String index (/*Model model*/) {
		//model.addAttribute("role", getRole());
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
