package com.techment.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techment.entity.Doctor;
import com.techment.service.IDoctorService;

@RestController
@RequestMapping(value = "doctorController")
public class DoctorController {

	@Autowired
	IDoctorService doctorService;
	
	@PostMapping("/addDoctor")
	public String registerDoctor(@Valid @RequestBody Doctor doctor)
	{
		doctorService.addDoctor(doctor);
		return "Doctor Registered Successfully";
	}
	
	@GetMapping("/getDoctor/{id}")
	public Doctor getDoctor(@Valid @PathVariable int id)
	{
		return doctorService.getDoctor(id);
	
	}
	
	@DeleteMapping("/removeDoctor")
	public String removeDoctor(@Valid @RequestBody int id) {
		return doctorService.removeDoctor(id);
	}
	
	@GetMapping("/getDoctorList")
	public List<Doctor> getDoctorList(){
		return doctorService.getDoctorList();
	}
	
	
	@GetMapping("/getDoctorListBySpeciality/{speciality}")
	public List<Doctor> getDoctorListBySpeciality(@Valid @PathVariable String speciality){
		return doctorService.getDoctorListBySpeciality(speciality);
	}
	
	@PutMapping("/updateDoctor/{id}")
	public String updateDoctor(@Valid @RequestBody Doctor doctor,@PathVariable int id)
	{
		return doctorService.updateDoctor(doctor, id);
	}
	
	
}
