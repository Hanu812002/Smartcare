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

import com.healthcareservices.entity.Document;
import com.healthcareservices.service.DocumentService;

@RestController
public class DocumentController {
	
	@Autowired
	private DocumentService theDocumentService;
	
	@CrossOrigin
	@GetMapping("/documents")
	public List<Document> listDocuments() {
		return theDocumentService.findAll();
	}
	
	@CrossOrigin
	@GetMapping("/documents/{documentId}")
	public Document findDocumentById(int documentId) {
		Document tempDocument = theDocumentService.findById(documentId);
		
		if(tempDocument == null) {  // did this intentionally will remove it later...
			return null;
		} else {
			return tempDocument;
		}
	}
	
	@CrossOrigin
	@PostMapping("/documents")
	public Document saveDocument(@RequestBody Document theDocument) {
		
		// also just in case they pass an id in JSON ... set id to 0
        // this is to force a save of new item ... instead of update
		theDocument.setId(0);

        Document dbDocument = theDocumentService.save(theDocument);

        return dbDocument;
	}
	
	@CrossOrigin
	@PutMapping("/documents")
	public Document update(@RequestBody Document theDocument) {
		
		Document dbDocument = theDocumentService.save(theDocument);
		
		return dbDocument;
	}
	
	@CrossOrigin
	@DeleteMapping("/documents/{documentId}")
	public void deleteDocument(int documentId) {
		
		Document tempDocument = theDocumentService.findById(documentId);
		
		if(tempDocument == null) {
			throw new RuntimeException("Document id not found" + documentId);
		} else {
			theDocumentService.deleteById(documentId);
		}
		
		System.out.println("Deleted Document id - " + documentId);
	}
	
}
