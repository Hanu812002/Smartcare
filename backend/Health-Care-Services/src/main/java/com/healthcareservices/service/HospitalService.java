package com.healthcareservices.service;

import java.util.List;

import com.healthcareservices.entity.Hospital;


public interface HospitalService {

	List<Hospital> findAll();

    Hospital findById(Integer theId);

    Hospital save(Hospital theDoctor);

    void deleteById(int theId);
    
    Hospital findByName(String theName);
    
    void deleteByName(String theName);
}
