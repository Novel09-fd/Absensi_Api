package com.example.absensiandroid.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor

@Entity
@Table(name = "absensi")
public class Absensi {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long id;
	private String user;
	private String dataFotoMasuk;
	private String dataFotoKeluar;
	private String tanggalMasuk;
	private String tanggalKeluar;
	private int jamMasuk;
	private int jamKeluar;
	private String gps;
}
