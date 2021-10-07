package com.techment.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.techment.entity.Doctor;

public interface IDoctorDao extends JpaRepository<Doctor, Integer> {

	List<Doctor> findAllDoctorsBySpeciality(String speciality);
	
}
