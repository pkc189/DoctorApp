package com.techment.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techment.exception.PatientNotFound;
import com.techment.dto.Patientdto;
import com.techment.entity.Patient;
import com.techment.service.IPatientService;

@RestController
@RequestMapping(value = "/clientController")
public class PatientController {
	
	@Autowired
	IPatientService clientService;
	
	@PostMapping(value = "/addClient")
	public ResponseEntity<String> addnewClient(@RequestBody Patientdto client)
	{		
			String OutputString =clientService.AddClient(client);
			return new ResponseEntity<String>(OutputString,HttpStatus.ACCEPTED);		
	}
	
	@GetMapping("/viewAll")
	public List<Patientdto> ViewClients()
	{
		return clientService.GetClients();
	}
	
	@GetMapping("/viewAll/{id}")
	public Patientdto ViewClientById(@PathVariable int id)
	{
		try
		{
			Patientdto patient = clientService.GetClientById(id);
			if(patient==null)
			{
				throw new PatientNotFound("No User found");
				
			}
			else 
				return patient;
		}
		catch (Exception e) {
			return null;
		}
		
	}
	
	@PutMapping("/UpdateClient/{id}")
	public ResponseEntity<String>  ViewClientById(@PathVariable int id,@RequestBody Patient client)
	{
			
			
			try {
				Patientdto clientupdate = clientService.GetClientById(id);
				if(clientupdate!=null)
				{
					clientupdate.setPatientAddress(client.getPatientAddress());
					clientupdate.setPatientAge(client.getPatientAge());
					clientupdate.setPatientBloodGroup(client.getPatientBloodGroup());
					clientupdate.setPatientEmail(client.getPatientEmail());
					clientupdate.setPatientGender(client.getPatientGender());
					clientupdate.setPatientMobile(client.getPatientMobile());
					clientupdate.setPatientName(client.getPatientName());
					clientupdate.setPatientPassword(client.getPatientPassword());
					
					clientService.AddClient(clientupdate);
					
					return new ResponseEntity<String>("Client Updated",HttpStatus.ACCEPTED);
				}
				else
					return new ResponseEntity<String>(HttpStatus.BAD_GATEWAY);
			} catch (Exception e) {
				return null;
			}
			
			
				
	}
	
	@DeleteMapping("/DeleteClient/{id}")
	public ResponseEntity<String> DeleteClientById(@PathVariable int id)
	{
		clientService.DeleteClientById(id);
		return new ResponseEntity<String>("Client Deleted Successfully",HttpStatus.ACCEPTED);
	}
	@GetMapping("/Login/{username}/{password}")
	public Patientdto LoginPatient(@PathVariable String username,@PathVariable String password)
	{
		return clientService.PatientLogin(username,password);
	}
	
	
}
