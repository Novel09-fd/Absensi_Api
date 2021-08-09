package com.example.absensiandroid.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.example.absensiandroid.entity.Login;

public interface LoginRepository extends JpaRepository<Login, Long> {
	@Query(value = "SELECT * FROM login WHERE username LIKE %?1% AND password LIKE %?2%", nativeQuery = true)
	List<Login> findByUsername(String name, String password);
}
