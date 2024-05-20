package com.healthcareservices.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name="patient")
public class Patient {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="patient_id")
	private int id;
	
	@Column(name="name")
	@NotNull(message="is required")
	private String name;
	
	@Column(name="age")
	@NotNull(message="is required")
	private int age;
	
	@Column(name="medical_history")
	@NotNull(message="is required")
	private String medicalHistory;
	
	@Column(name="contact")
	@NotNull(message="is required")
	private long contact;
	
	
	@Column(name="pwd")
	private String pwd;
	
	@Column(name="file")
	private String file;
	
	
	public Patient() {
		
	}
	
	public Patient(String name, int age, long contact, String data, String medicalHistory) {
		this.name = name;
		this.age = age;
		this.contact = contact;
		this.file = data;
		this.medicalHistory = medicalHistory;
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

	public long getContact() {
		return contact;
	}

	public void setContact(long contact) {
		this.contact = contact;
	}
	
	public String getMedicalHistory() {
		return medicalHistory;
	}

	public void setMedicalHistory(String medicalHistory) {
		this.medicalHistory = medicalHistory;
	}
	
	public String getFile() {
		return file;
	}

	public void setFile(String theFile) {
		this.file = theFile;
	}

	public String getPwd() {
		return pwd;
	}

	public void setPwd(String pwd) {
		this.pwd = pwd;
	}

	@Override
	public String toString() {
		return "Patient [id=" + id + ", name=" + name + ", age=" + age + ", medicalHistory=" + medicalHistory
				+ ", contact=" + contact + ", pwd=" + pwd + ", file=" + file + "]";
	}
	
}
