package com.example.service;

import org.springframework.stereotype.Service;

import com.example.model.UserAccountModel;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserAccountServiceDatabase implements UserAccountService{

	@Override
	public UserAccountModel selectUserAccount(String userName, String password) {
		// TODO Auto-generated method stub
		return null;
	}
	
}
