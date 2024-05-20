package com.healthcareservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.healthcareservices.entity.Patient;
import com.healthcareservices.service.PatientService;

@RestController
public class PatientController {
	
	@Autowired
	private PatientService thePatientService;
	
	//InitBinder is executed first.
		//this function will check for the leading and trailing white spaces in the input data
		@InitBinder
		public void initBinder(WebDataBinder dataBinder) {
			
			//here true means if only blank spaces are present it will make the blank spaces to null.
			//else it will delete trailing and front spaces
			StringTrimmerEditor stringTrimmerEditor = new StringTrimmerEditor(true);
			
			dataBinder.registerCustomEditor(String.class, stringTrimmerEditor);
		}
	
	@CrossOrigin
	@GetMapping("/patients")
	public List<Patient> listPatients() {
		return thePatientService.findAll();
	}
	
	@CrossOrigin
	@GetMapping("/patients/{patientId}")
	public Patient getPatient(int patientId) {
		return thePatientService.findById(patientId);
	}
	@CrossOrigin
	@PostMapping("/patients")
	public Patient save(@RequestBody Patient thePatient) {
		
		thePatient.setId(0);
		
		Patient dbPatient = thePatientService.save(thePatient);
		
		return dbPatient;
	}
	
	@CrossOrigin
	@PutMapping("/patients/{patientId}")
	public Patient update(@RequestBody Patient thePatient) {
		
		Patient dbPatient = thePatientService.save(thePatient);
		
		return dbPatient;
	}
	
	@CrossOrigin
	@DeleteMapping("/patients/{patientId}")
	public void deletePatient(int thePatientId) {
		Patient tempPatient = thePatientService.findById(thePatientId);
		
		if(tempPatient == null) {
			throw new RuntimeException("Doctor id not found" + thePatientId);
		} else {
			thePatientService.deleteById(thePatientId);
		}
		
		System.out.println("Deleted Patient id - " + thePatientId);
	}
	
}
