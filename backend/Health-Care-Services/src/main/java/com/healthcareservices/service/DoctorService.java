package com.healthcareservices.service;

import java.util.List;

import com.healthcareservices.entity.Doctor;

public interface DoctorService {

	List<Doctor> findAll();

    Doctor findById(int theId);

    Doctor save(Doctor theDoctor);

    void deleteById(int theId);
    
    Doctor findByName(String theName);
    
    void deleteByName(String name);
}
