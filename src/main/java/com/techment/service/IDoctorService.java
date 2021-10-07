package com.techment.service;

import java.util.List;

import com.techment.entity.Doctor;

public interface IDoctorService {

	String addDoctor(Doctor doctor);
	Doctor getDoctor(int id);
	String removeDoctor(int id);
	List<Doctor> getDoctorList();
	List<Doctor> getDoctorListBySpeciality(String speciality);
	String updateDoctor(Doctor doctor,int id);
	
}
