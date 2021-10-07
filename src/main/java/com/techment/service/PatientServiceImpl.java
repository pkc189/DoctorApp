package com.techment.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.techment.dao.IPatientDao;
import com.techment.dto.Patientdto;
import com.techment.entity.Patient;

@Service
public class PatientServiceImpl implements IPatientService {

	@Autowired
	IPatientDao clientdao;
	
	@Override
	public String AddClient(Patientdto client) {
		
		if(client.getPatientAddress()==null||client.getPatientAddress()=="")
		{
			return "Please Give The Proper Address";
		}
		else if(client.getPatientAge()<1||client.getPatientAge()>110)
		{
			return "Please Give The Proper Age";
		}
		else if(client.getPatientBloodGroup()==null||client.getPatientBloodGroup()=="")
		{
			return "Please Give The Proper Blood Group";
		}
		else if(client.getPatientEmail()==null||client.getPatientEmail()=="")
		{
			return "Please Give The Proper Email";
		}
		else if(client.getPatientGender()==null||client.getPatientGender()=="")
		{
			return "Please Give The Proper Gender";
		}
		else if(client.getPatientMobile()==null||client.getPatientMobile()=="")
		{
			return "Please Give The Proper Mobile Number";
		}
		else if(client.getPatientName()==null||client.getPatientName()=="")
		{
			return "Please Give The Proper Name";
		}
		else if(client.getPatientPassword()==null||client.getPatientPassword()=="")
		{
			return "Please Give The Proper Password";
		}
		else
		{
		Patient patient = new Patient(client.getPatientName(),client.getPatientMobile(),client.getPatientEmail(),client.getPatientPassword(),client.getPatientBloodGroup(),client.getPatientGender(),client.getPatientAge(),client.getPatientAddress());
		clientdao.save(patient);
		return "Details Of Client Added Successfully";
	}
		}

	@Override
	public List<Patientdto> GetClients() {
		List<Patient> clients = clientdao.findAll();
		List<Patientdto> clientList = new ArrayList<Patientdto>();
		for(Patient client : clients )
		{
			clientList.add(new Patientdto(client.getPatientName(),
					client.getPatientMobile(), client.getPatientEmail(),
					client.getPatientPassword(), client.getPatientBloodGroup(),
					client.getPatientGender(), client.getPatientAge(), client.getPatientAddress()));			
		}
		return clientList;
	}

	@Override
	public Patientdto GetClientById(int id) {
		Patient client = clientdao.findById(id).get();
//		if(client==null)
//		{
//			return "No Client With This Id";
//		}
		Patientdto clientdto =new Patientdto(client.getPatientName(), client.getPatientMobile(), client.getPatientEmail(), client.getPatientPassword(), client.getPatientBloodGroup(), client.getPatientGender(), client.getPatientAge(), client.getPatientAddress());
		return clientdto;
	}

	@Override
	public String DeleteClientById(int id) {
		
		clientdao.deleteById(id);
		return "Client Deleted Successfully";
	}

	@Override
	public Patientdto PatientLogin(String username, String password) {
		Patient client = clientdao.findByPatientMobileAndPatientPassword(username, password);
		Patientdto patient =new Patientdto(client.getPatientName(), client.getPatientMobile(), client.getPatientEmail(), client.getPatientPassword(), client.getPatientBloodGroup(), client.getPatientGender(), client.getPatientAge(), client.getPatientAddress());
		return patient;
//		return null;
	}

}
