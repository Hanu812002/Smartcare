package com.healthcareservices.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.healthcareservices.entity.Document;

@Repository
public interface DocumentRepository extends JpaRepository<Document, Integer> {

}
