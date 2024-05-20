package com.healthcareservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.healthcareservices.entity.MedicalHistory;
import com.healthcareservices.service.MedicalService;

@RestController
public class MedicalController {

	@Autowired
	private MedicalService theMedicalSevice;
	
	@CrossOrigin
	@GetMapping("/medicals")
	public List<MedicalHistory> listMedical() {
		return theMedicalSevice.findAll();
	}
	
	@CrossOrigin
	@GetMapping("/medicals/{medicalId}")
	public MedicalHistory findMedicalById(int medicalId) {
		MedicalHistory tempHistory = theMedicalSevice.findById(medicalId);
		
		if(tempHistory == null) {  // did this intentionally will remove it later...
			return null;
		} else {
			return tempHistory;
		}
	}
	
	@CrossOrigin
	@PostMapping("/medicals")
	public MedicalHistory saveMedical(@RequestBody MedicalHistory theMedicalHistory) {
		
		// also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update
		theMedicalHistory.setId(0);

		MedicalHistory tempHistory = theMedicalSevice.save(theMedicalHistory);

        return tempHistory;
	}
	
	@CrossOrigin
	@PutMapping("/medicals")
	public MedicalHistory update(@RequestBody MedicalHistory theMedicalHistory) {
		
		MedicalHistory tempHistory = theMedicalSevice.save(theMedicalHistory);
		
		return tempHistory;
	}
	
	@CrossOrigin
	@DeleteMapping("/medicals/{medicalId}")
	public void deleteMedical(int medicalId) {
		
		MedicalHistory tempHistory = theMedicalSevice.findById(medicalId);
		
		if(tempHistory == null) {
			throw new RuntimeException("MedicalHistory id not found" + medicalId);
		} else {
			theMedicalSevice.deleteById(medicalId);
		}
		
		System.out.println("Deleted MedicalHistory id - " + medicalId);
	}
	
}
