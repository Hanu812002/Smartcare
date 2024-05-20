package com.healthcareservices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcareservices.dao.DoctorRepository;
import com.healthcareservices.entity.Doctor;

@Service
public class DoctorServiceImpl implements DoctorService {

    private DoctorRepository doctorRepository;

    @Autowired
    public DoctorServiceImpl(DoctorRepository theDoctorRepository) {
    	doctorRepository = theDoctorRepository;
    }

    @Override
    public List<Doctor> findAll() {
        return doctorRepository.findAll();
    }

    @Override
    public Doctor findById(int theId) {
        Optional<Doctor> result = doctorRepository.findById(theId);

        Doctor theDoctor = null;

        if (result.isPresent()) {
            theDoctor = result.get();
        }
        else {
            // we didn't find the doctor
            throw new RuntimeException("Did not find doctor id - " + theId);
        }

        return theDoctor;
    }

    @Override
    public Doctor save(Doctor theDoctor) {
        return doctorRepository.save(theDoctor);
    }

    @Override
    public void deleteById(int theId) {
    	doctorRepository.deleteById(theId);
    }

	@Override
	public Doctor findByName(String theName) {
		return doctorRepository.findByName(theName);
		
	}

	@Override
	public void deleteByName(String name) {
		Doctor theDoctor = doctorRepository.findByName(name);
		
		doctorRepository.deleteById(theDoctor.getId());
	}
}
