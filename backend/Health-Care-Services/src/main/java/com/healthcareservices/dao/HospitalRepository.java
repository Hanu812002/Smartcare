package com.healthcareservices.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.healthcareservices.entity.Hospital;

@Repository
public interface HospitalRepository extends JpaRepository<Hospital, Integer>{
	
	Hospital findByName(String theName);
}
