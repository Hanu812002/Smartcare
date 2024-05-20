package com.healthcareservices.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.healthcareservices.entity.Patient;

@Repository
public interface PatientRepository extends JpaRepository<Patient, Integer> {
	
	Patient findByName(String name);
}
