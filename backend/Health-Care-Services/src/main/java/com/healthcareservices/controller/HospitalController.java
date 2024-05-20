package com.healthcareservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.healthcareservices.entity.Hospital;
import com.healthcareservices.service.HospitalService;

@RestController
public class HospitalController {

	@Autowired
	private HospitalService theHospitalService;
	
	@CrossOrigin
	@PostMapping("/hospitals")
	public Hospital saveHospital(@RequestBody Hospital theHospital) {
		theHospital.setId(0);
		
		Hospital dbHospital = theHospitalService.save(theHospital);
		
		return dbHospital;
	}
	
	@CrossOrigin
	@GetMapping("/hospitals")
	public List<Hospital> listHospital() {
		return theHospitalService.findAll();
	}
	
	@CrossOrigin
	@GetMapping("/hospitals/{hospitalId}")
	public Hospital getHospital(@PathVariable int hospitalId) {
		
		Hospital tempHospital = theHospitalService.findById(hospitalId);
		
		if(tempHospital == null) { // did this intentionally will remove this later...
			return null;
		} else {
			return tempHospital;
		}
	}
	
	@CrossOrigin
	@PutMapping("/hospitals")
	public Hospital update(@RequestBody Hospital theHospital) {
		
		Hospital dbHospital = theHospitalService.save(theHospital);
		
		return dbHospital;
	}

	@CrossOrigin
	@DeleteMapping("/hospitals/{hospitalId}")
	public String deleteHospital(@PathVariable int hospitalId) {
		Hospital tempHospital = theHospitalService.findById(hospitalId);
		
		if(tempHospital == null) {
			throw new RuntimeException("Hospital id not found - " + hospitalId);
		} else {
			theHospitalService.deleteById(hospitalId);
		}
		
		return "Deleted Hospital id - " + hospitalId;
	}
}
