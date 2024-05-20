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

import com.healthcareservices.entity.Doctor;
import com.healthcareservices.service.DoctorService;

@RestController
public class DoctorController {
	
	@Autowired
	private DoctorService theDoctorService;
	
	@CrossOrigin
	@GetMapping("/doctors")
	public List<Doctor> listDoctors() {
		return theDoctorService.findAll();
	}
	
	@CrossOrigin
	@GetMapping("/doctors/{doctorId}")
	public Doctor findDoctorById(int doctorId) {
		Doctor tempDoctor = theDoctorService.findById(doctorId);
		
		if(tempDoctor == null) {  // did this intentionally will remove it later...
			return null;
		} else {
			return tempDoctor;
		}
	}
	
	@CrossOrigin
	@PostMapping("/doctors")
	public Doctor saveDoctor(@RequestBody Doctor theDoctor) {
		
		// also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update
		theDoctor.setId(0);

        Doctor dbDoctor = theDoctorService.save(theDoctor);

        return dbDoctor;
	}
	
	@CrossOrigin
	@PutMapping("/doctors")
	public Doctor update(@RequestBody Doctor theDoctor) {
		
		Doctor dbDoctor = theDoctorService.save(theDoctor);
		
		return dbDoctor;
	}
	
	@CrossOrigin
	@DeleteMapping("/doctors/{doctorId}")
	public void deleteDoctor(int doctorId) {
		
		Doctor tempDoctor = theDoctorService.findById(doctorId);
		
		if(tempDoctor == null) {
			throw new RuntimeException("Doctor id not found" + doctorId);
		} else {
			theDoctorService.deleteById(doctorId);
		}
		
		System.out.println("Deleted Doctor id - " + doctorId);
	}
	
}
