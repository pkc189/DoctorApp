package com.techment.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.techment.dao.IDoctorDao;
import com.techment.entity.Doctor;

@Service
public class DoctorServiceImpl implements IDoctorService {

	@Autowired
	IDoctorDao dao;

	@Override
	public String addDoctor(Doctor doctor) {
		
		dao.save(doctor);
		return "Doctor Registerd Successfully";
	}

	@Override
	public Doctor getDoctor(int id) {
		// TODO Auto-generated method stub
		return dao.findById(id).get();
	}

	@Override
	public String removeDoctor(int id) {
		// TODO Auto-generated method stub
		dao.deleteById(id);
		return "Doctor deleted successfully";
	}

	@Override
	public List<Doctor> getDoctorList() {
		// TODO Auto-generated method stub
		return dao.findAll();
	}

	

	@Override
	public List<Doctor> getDoctorListBySpeciality(String speciality) {
		// TODO Auto-generated method stub
		return dao.findAllDoctorsBySpeciality(speciality);
	}

	
	@Override
	public String updateDoctor(Doctor d,int id) {
		
		Doctor  exsitingDoctor = dao.findById(id).get();
		
		exsitingDoctor.setName(d.getName());
		exsitingDoctor.setAge(d.getAge());
		exsitingDoctor.setAddress(d.getAddress());
		exsitingDoctor.setAvailableDay(d.getAvailableDay());
		exsitingDoctor.setAvailableTime(d.getAvailableTime());
		exsitingDoctor.setBio(d.getBio());
		exsitingDoctor.setCity(d.getCity());
		exsitingDoctor.setExperience(d.getExperience());
		exsitingDoctor.setFees(d.getFees());
		exsitingDoctor.setGender(d.getGender());
		exsitingDoctor.setMobile(d.getMobile());
		exsitingDoctor.setQualification(d.getQualification());
		exsitingDoctor.setSpeciality(d.getSpeciality());
	
		return "Updated successfully";
	}
	
	
	
	
}
