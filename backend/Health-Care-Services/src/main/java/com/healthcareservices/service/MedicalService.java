package com.healthcareservices.service;

import java.util.List;

import com.healthcareservices.entity.MedicalHistory;

public interface MedicalService {

	List<MedicalHistory> findAll();

	MedicalHistory findById(int theId);

	MedicalHistory save(MedicalHistory theMedicalHistory);

    void deleteById(int theId);
//    
//    MedicalHistory findByName(String theName);
//    
//    void deleteByName(String name);
}
