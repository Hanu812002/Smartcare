package com.healthcareservices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcareservices.dao.HospitalRepository;
import com.healthcareservices.entity.Hospital;

@Service
public class HospitalServiceImpl implements HospitalService {

    private HospitalRepository hospitalRepository;

    @Autowired
    public HospitalServiceImpl(HospitalRepository theHospitalRepository) {
    	hospitalRepository = theHospitalRepository;
    }

    @Override
    public List<Hospital> findAll() {
        return hospitalRepository.findAll();
    }

    @Override
    public Hospital findById(Integer theId) {
        Optional<Hospital> result = hospitalRepository.findById(theId);

        Hospital theHospital = null;

        if (result.isPresent()) {
            theHospital = result.get();
        }
        else {
            // we didn't find the doctor
            throw new RuntimeException("Did not find hospital id - " + theId);
        }

        return theHospital;
    }

    @Override
    public Hospital save(Hospital theHospital) {
        return hospitalRepository.save(theHospital);
    }

    @Override
    public void deleteById(int theId) {
    	hospitalRepository.deleteById(theId);
    }

	@Override
	public Hospital findByName(String theName) {
		return hospitalRepository.findByName(theName);
		
	}
	
	@Override
	public void deleteByName(String theName) {
		Hospital theHospital = hospitalRepository.findByName(theName);
		
		hospitalRepository.deleteById(theHospital.getId());
		
	}
}
