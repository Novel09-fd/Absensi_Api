package com.example.absensiandroid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.absensiandroid.entity.Login;
import com.example.absensiandroid.repository.LoginRepository;

@Service
public class ModelLogin implements ModelLoginInterface {

	@Autowired
	LoginRepository loginRepository;
	
	@Override
	public List<Login> getByUsername(String name, String password) {
		// TODO Auto-generated method stub
		return this.loginRepository.findByUsername(name, password);
	}

}
