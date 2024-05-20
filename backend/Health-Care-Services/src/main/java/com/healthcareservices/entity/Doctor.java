package com.healthcareservices.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Pattern;

@Entity
@Table(name="doctor")
public class Doctor {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="doctor_id")
	private int id;
	
	@NotNull(message="is required")
	@Column(name="name")
	private String name;
	
	@NotNull(message="is required")
	@Column(name="speciality")
	private String speciality;
	
	@Column(name="education")
	private String education;
	
	@Column(name="experience")
	private int experience;
	
	@NotNull(message="is required")
	@Column(name="location")
	private String location;
	
	@NotNull(message="is required")
	@Column(name="contact")
	private long contact;
	
	@Pattern(regexp="^[a-zA-Z0-9.!#$%&'*+/=?^_`{|}~-]+@[a-zA-Z0-9-]+(?:\\.[a-zA-Z0-9-]+)*$", message="isrequired")
	@Column(name="email")
	private String email;
	
	@Column(name="hospital")
	private String hospital;
	
	@Column(name="pwd")
	private String pwd;
	
	@Column(name="file")
	private String file;	

	public Doctor() {
		super();
	}

	public Doctor(String name, String speciality, String education, int experience, String location, long contact,
			String email, String hospital, String file) {
		super();
		this.name = name;
		this.speciality = speciality;
		this.education = education;
		this.experience = experience;
		this.location = location;
		this.contact = contact;
		this.email = email;
		this.hospital = hospital;
		this.file = file;
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

	public String getSpeciality() {
		return speciality;
	}

	public void setSpeciality(String speciality) {
		this.speciality = speciality;
	}

	public String getEducation() {
		return education;
	}

	public void setEducation(String education) {
		this.education = education;
	}

	public int getExperience() {
		return experience;
	}

	public void setExperience(int experience) {
		this.experience = experience;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getHospital() {
		return hospital;
	}

	public void setHospital(String hospital) {
		this.hospital = hospital;
	}

	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "Doctor [id=" + id + ", name=" + name + ", speciality=" + speciality + ", education=" + education
				+ ", experience=" + experience + ", location=" + location + ", contact=" + contact + ", email=" + email
				+ ", hospital=" + hospital + ", file=" + file + "]";
	}
	
	
	
}
