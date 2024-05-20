package com.healthcareservices.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.validation.constraints.NotNull;

@Table(name="hospital")
@Entity
public class Hospital {

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	@Column(name="hospital_id")
	private Integer id;
	
	@Column(name="name")
	@NotNull(message="is required")
	private String name;
	
	@Column(name="location")
	@NotNull(message="is required")
	private String location;
	
	@Column(name="contact")
	@NotNull(message="is required")
	private long contact;

	public Hospital() {
		super();
	}

	public Hospital( String name, String location, long contact) {
		super();
		this.name = name;
		this.location = location;
		this.contact = contact;
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

	@Override
	public String toString() {
		return "Hospital [id=" + id + ", name=" + name + ", location=" + location + ", contact=" + contact +"]";
	}
	
	
}
