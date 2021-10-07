package com.techment.entity;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;


@Entity
@Table(name = "DoctorApp365")
public class Doctor {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	int id;
	@NotNull (message="name is required")
	@NotBlank (message="name can not be empty")
	String name;
	
	@NotNull (message="age is required")
	@Min(10)
	@Max(100)
	int age;
	
	@NotNull (message="experience is required")
	@Min(0)
	@Max(50)
	int experience;
	
	@NotNull (message="qualification is required")
	@NotBlank (message="qualification can not be empty")
	String qualification;
	
	@NotNull (message="city is required")
	@NotBlank (message="city can not be empty")
	String city;
	
	@NotNull (message="fees is required")
	int fees;
	
	@NotNull (message="gender is required")
	@NotBlank (message="gender can not be empty")
	String gender;
	
	@NotNull (message="mobile is required")
	@NotBlank (message="mobile can not be empty")
	@Column(unique = true)
	String mobile;
	
	@NotNull (message="address is required")
	@NotBlank (message="address can not be empty")
	String address;
	
	@NotNull (message="bio is required")
	@NotBlank (message="bio can not be empty")
	@Size(min=10,max=300)
	String bio;
	
	@NotNull (message="day is required")
	@NotBlank (message="day can not be empty")
	String availableDay;
	
	@NotNull (message="time is required")
	@NotBlank (message="time can not be empty")
	String availableTime;
	
	@NotNull (message="speciality is required")
	@NotBlank (message="speciality can not be empty")
	String speciality;
	
	public Doctor() {
		super();
		// TODO Auto-generated constructor stub
	}

	public String getSpeciality() {
		return speciality;
	}

	public Doctor(String name, int age, int experience, String qualification, String city, int fees, String gender,
			String mobile, String address, String bio, String availableDay, String availableTime, String speciality) {
		super();
		this.name = name;
		this.age = age;
		this.experience = experience;
		this.qualification = qualification;
		this.city = city;
		this.fees = fees;
		this.gender = gender;
		this.mobile = mobile;
		this.address = address;
		this.bio = bio;
		this.availableDay = availableDay;
		this.availableTime = availableTime;
		this.speciality = speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getBio() {
		return bio;
	}

	public void setBio(String bio) {
		this.bio = bio;
	}

	public String getAvailableDay() {
		return availableDay;
	}

	public void setAvailableDay(String availableDay) {
		this.availableDay = availableDay;
	}

	public String getAvailableTime() {
		return availableTime;
	}

	public void setAvailableTime(String availableTime) {
		this.availableTime = availableTime;
	}



	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getQualification() {
		return qualification;
	}

	public void setQualification(String qualification) {
		this.qualification = qualification;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public int getFees() {
		return fees;
	}

	public void setFees(int fees) {
		this.fees = fees;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getAddress() {
		return address;
	}

	public void setAddress(String address) {
		this.address = address;
	}
	
	
	
	
	
	

}
