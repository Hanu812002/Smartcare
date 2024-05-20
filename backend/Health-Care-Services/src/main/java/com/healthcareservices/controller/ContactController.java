package com.healthcareservices.controller;

import java.sql.Date;
import java.util.Random;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.healthcareservices.dao.ContactRepository;
import com.healthcareservices.entity.Contact;


@RestController
public class ContactController {

	@Autowired
	private ContactRepository theContactRepository;
	
	@CrossOrigin
	@PostMapping("/contacts")
	public Contact saveContactInquiryDetails(@RequestBody Contact theContact) {
		theContact.setContactId(getServiceReqNumber());
		theContact.setCreateDt(new Date(System.currentTimeMillis()));
		return theContactRepository.save(theContact);
	}
	
	public String getServiceReqNumber() {
		Random random = new Random();
		int ranNum = random.nextInt(999999999 - 9999) + 9999;
		// SR indicates this is a Service Request.
		return "SR" + ranNum;
	}
}
