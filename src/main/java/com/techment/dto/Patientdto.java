package com.techment.dto;

public class Patientdto {
	
	int patientId;
	String patientName;
	String patientMobile;
	String patientEmail;
	String patientPassword;
	String patientBloodGroup;
	String patientGender;
	int patientAge;
	String patientAddress;
	public Patientdto(String patientName, String patientMobile, String patientEmail, String patientPassword,
			String patientBloodGroup, String patientGender, int patientAge, String patientAddress) {
		super();
		this.patientName = patientName;
		this.patientMobile = patientMobile;
		this.patientEmail = patientEmail;
		this.patientPassword = patientPassword;
		this.patientBloodGroup = patientBloodGroup;
		this.patientGender = patientGender;
		this.patientAge = patientAge;
		this.patientAddress = patientAddress;
	}
	public Patientdto() {
		super();
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getPatientMobile() {
		return patientMobile;
	}
	public void setPatientMobile(String patientMobile) {
		this.patientMobile = patientMobile;
	}
	public String getPatientEmail() {
		return patientEmail;
	}
	public void setPatientEmail(String patientEmail) {
		this.patientEmail = patientEmail;
	}
	public String getPatientPassword() {
		return patientPassword;
	}
	public void setPatientPassword(String patientPassword) {
		this.patientPassword = patientPassword;
	}
	public String getPatientBloodGroup() {
		return patientBloodGroup;
	}
	public void setPatientBloodGroup(String patientBloodGroup) {
		this.patientBloodGroup = patientBloodGroup;
	}
	public String getPatientGender() {
		return patientGender;
	}
	public void setPatientGender(String patientGender) {
		this.patientGender = patientGender;
	}
	public int getPatientAge() {
		return patientAge;
	}
	public void setPatientAge(int patientAge) {
		this.patientAge = patientAge;
	}
	public String getPatientAddress() {
		return patientAddress;
	}
	public void setPatientAddress(String patientAddress) {
		this.patientAddress = patientAddress;
	}		
}
