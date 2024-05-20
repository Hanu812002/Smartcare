package com.healthcareservices.service;

import java.util.List;

import com.healthcareservices.entity.Document;

public interface DocumentService {

	List<Document> findAll();

    Document findById(int theId);

    Document save(Document theDocument);

    void deleteById(int theId);
    
//    Document findByName(String theName);
//    
//    void deleteByName(String name);
}
