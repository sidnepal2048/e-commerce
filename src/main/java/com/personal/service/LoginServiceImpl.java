package com.personal.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.dao.Login;

@Service
public class LoginServiceImpl implements LoginService {
	
	@Autowired
	private Login logindao;
	@Override
	public boolean validateUser(String email, String password) {
		
		return logindao.validateUser(email, password);
	}

}
