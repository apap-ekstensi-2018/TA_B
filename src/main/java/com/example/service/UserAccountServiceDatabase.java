package com.example.service;

import java.util.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Service;

import com.example.model.MahasiswaModel;
import com.example.model.PegawaiModel;
import com.example.model.UserAccountModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserAccountServiceDatabase implements UserAccountService{
	
	@Autowired
	MahasiswaService mahasiswaService;
	
	@Autowired
	PegawaiService pegawaiService;
	
	@Override
	public UserAccountModel selectUserAccount() {
		UserAccountModel userAccount = new UserAccountModel();
		String role = null;
		Authentication auth = SecurityContextHolder.getContext().getAuthentication();   
		UserDetails userDetails = (UserDetails) auth.getPrincipal();
		if (userDetails instanceof UserDetails) {
            Collection<? extends GrantedAuthority> grantedAuthorities = ((UserDetails)userDetails).getAuthorities();
            for (GrantedAuthority a : grantedAuthorities) {
                role = a.getAuthority();	
            }
        } else {
            role = userDetails.toString();
        }
		
		log.info("Select detail information of user " + auth.getName());
		
        userAccount.setUserName(auth.getName());
        userAccount.setRole(role);
        if (role.equals("ROLE_MAHASISWA")){
        	MahasiswaModel mahasiswa = mahasiswaService.selectMahasiswaByNpm(auth.getName());
        	userAccount.setName(mahasiswa.getNama());
        	userAccount.setId(mahasiswa.getId());
        }
        
        if (role.equals("ROLE_STAF")) {
        	PegawaiModel pegawai = pegawaiService.selectPegawaiByNip(auth.getName());
        	userAccount.setName(pegawai.getNama());
        	userAccount.setId(pegawai.getId());
        }
        
		return userAccount;
	}
	
}
