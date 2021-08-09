package com.example.absensiandroid.service;

import java.util.List;

import com.example.absensiandroid.entity.Login;

public interface ModelLoginInterface {
	public List<Login> getByUsername(String name, String password);
}
