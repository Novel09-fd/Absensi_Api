package com.example.absensiandroid.service;

import java.util.List;

import com.example.absensiandroid.entity.Absensi;

public interface ModelAbsensiInterface {
	public List<Absensi> getAbsensiByName(String name);
	public String Absensi(Absensi absensi);
}
