package com.example.absensiandroid.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.absensiandroid.entity.Absensi;
import com.example.absensiandroid.repository.AbsensiRepository;

@Service
public class ModelAbsensi implements ModelAbsensiInterface {

	@Autowired
	AbsensiRepository absensiRepository;

	@Override
	public List<Absensi> getAbsensiByName(String user) {
		// TODO Auto-generated method stub
		return this.absensiRepository.getByUsername(user);
	}

	public String Absensi (Absensi absensi) {
		
		if(absensi.getTanggalMasuk() != null) {
			if(this.absensiRepository.getByUsernameAndDateIn(
					absensi.getUser(), absensi.getTanggalMasuk()
					) == null) {
				this.absensiRepository.save(absensi);
				return "Anda berhasil checkin";
			}
			return "Anda Sudah Check In";
		} else if(absensi.getTanggalKeluar() != null) {
			if (this.absensiRepository.getByUsernameAndDateOut(
					absensi.getUser(), absensi.getTanggalKeluar()
					) == null) {
				Absensi absensiTemp = this.absensiRepository
						.getByUsernameAndDateIn(
								absensi.getUser(), 
								absensi.getTanggalKeluar());
				if(absensiTemp != null) {
					absensi.setId(absensiTemp.getId());
					absensi.setTanggalMasuk(absensiTemp.getTanggalMasuk());
					absensi.setJamMasuk(absensiTemp.getJamMasuk());;
					absensi.setDataFotoMasuk(absensiTemp.getDataFotoMasuk());
					
					this.absensiRepository.save(absensi);
					return "Anda Berhasil checkout";
				} else {
					absensi.setTanggalMasuk(absensi.getTanggalKeluar());
					absensi.setDataFotoKeluar(null);
					absensi.setJamMasuk(absensi.getJamKeluar());
					
					absensi.setTanggalKeluar(null);
					absensi.setDataFotoKeluar(null);
					
					this.absensiRepository.save(absensi);
					return "Anda belum Check In Hari Ini";
				}
				
			}
			return "Anda Sudah Check Out";
		}
		else return "ada yang erorr";
	}



}
