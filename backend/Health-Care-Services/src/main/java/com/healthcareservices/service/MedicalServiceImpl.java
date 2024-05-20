package com.healthcareservices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcareservices.dao.MedicalRepository;
import com.healthcareservices.entity.MedicalHistory;

@Service
public class MedicalServiceImpl implements MedicalService {
	
	@Autowired
	public MedicalRepository theMedicalRepository;

	@Override
	public List<MedicalHistory> findAll() {
		return theMedicalRepository.findAll();
	}

	@Override
	public MedicalHistory findById(int theId) {
		
		Optional<MedicalHistory> result = theMedicalRepository.findById(theId);

        MedicalHistory theMedicalHistory = null;

        if (result.isPresent()) {
            theMedicalHistory = result.get();
        }
        else {
            // we didn't find the Document
            throw new RuntimeException("Did not find Document id - " + theId);
        }

        return theMedicalHistory;
	}

	@Override
	public MedicalHistory save(MedicalHistory theMedicalHistory) {
		
		return theMedicalRepository.save(theMedicalHistory);
	}

	@Override
	public void deleteById(int theId) {

		theMedicalRepository.deleteById(theId);
	}

//	@Override
//	public MedicalHistory findByName(String theName) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public void deleteByName(String name) {
//		// TODO Auto-generated method stub
//
//	}

}
