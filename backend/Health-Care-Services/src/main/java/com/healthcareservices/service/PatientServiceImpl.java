package com.healthcareservices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcareservices.dao.PatientRepository;
import com.healthcareservices.entity.Patient;

import jakarta.transaction.Transactional;

@Service
public class PatientServiceImpl implements PatientService{

	private PatientRepository patientRepository;

    @Autowired
    public PatientServiceImpl(PatientRepository thePatientRepository) {
    	patientRepository = thePatientRepository;
    }

    @Override
    public List<Patient> findAll() {
        return patientRepository.findAll();
    }

    @Override
    public Patient findById(int theId) {
        Optional<Patient> result = patientRepository.findById(theId);

        Patient thePatient = null;

        if (result.isPresent()) {
            thePatient = result.get();
        }
        else {
            // we didn't find the patient
            throw new RuntimeException("Did not find patient id - " + theId);
        }

        return thePatient;
    }

    @Override
    @Transactional
    public Patient save(Patient thePatient) {
        return patientRepository.save(thePatient);
    }

    @Override
    @Transactional
    public void deleteById(int theId) {
    	patientRepository.deleteById(theId);
    }

	@Override
	public Patient findByName(String theName) {
		return patientRepository.findByName(theName);
	}

	@Override
	@Transactional
	public void deleteByName(String theName) {

		Patient thePatient = patientRepository.findByName(theName);
		
		patientRepository.deleteById(thePatient.getId());
	}
	
}
