package com.healthcareservices.service;

import java.util.List;

import com.healthcareservices.entity.Patient;

public interface PatientService {

	List<Patient> findAll();

    Patient findById(int theId);

    Patient save(Patient thePatient);

    void deleteById(int theId);
    
    Patient findByName(String theName);
    
    void deleteByName(String theName);
}
