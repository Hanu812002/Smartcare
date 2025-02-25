package com.healthcareservices.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.healthcareservices.entity.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Long>{

}
