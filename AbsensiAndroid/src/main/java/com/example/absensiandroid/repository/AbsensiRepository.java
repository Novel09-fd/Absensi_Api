package com.example.absensiandroid.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.absensiandroid.entity.Absensi;

public interface AbsensiRepository extends JpaRepository<Absensi, Long> {
	@Query(value = "SELECT * FROM absensi WHERE username LIKE %?1%", nativeQuery = true)
	List<Absensi>getByUsername(String user);
	
	@Query(value = "Select * FROM absen WHERE username = ?1 AND tanggal_masuk = ?2", nativeQuery = true)
	public Absensi getByUsernameAndDateIn(String user, String date);
	
	@Query(value = "Select * FROM absen WHERE username = ?1 AND tanggal_keluar = ?2", nativeQuery = true)
	public Absensi getByUsernameAndDateOut(String user, String date);
}
