package com.healthcareservices.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.healthcareservices.dao.DocumentRepository;
import com.healthcareservices.entity.Document;

@Service
public class DocumentServiceImpl implements DocumentService {

	@Autowired
    private DocumentRepository theDocumentRepository;


    @Override
    public List<Document> findAll() {
        return theDocumentRepository.findAll();
    }

    @Override
    public Document findById(int theId) {
        Optional<Document> result = theDocumentRepository.findById(theId);

        Document theDocument = null;

        if (result.isPresent()) {
            theDocument = result.get();
        }
        else {
            // we didn't find the Document
            throw new RuntimeException("Did not find Document id - " + theId);
        }

        return theDocument;
    }

    @Override
    public Document save(Document theDocument) {
        return theDocumentRepository.save(theDocument);
    }

    @Override
    public void deleteById(int theId) {
    	theDocumentRepository.deleteById(theId);
    }

//	@Override
//	public Document findByName(String theName) {
//		return theDocumentRepository.findByName(theName);
//		
//	}
//
//	@Override
//	public void deleteByName(String name) {
//		Document theDocument = theDocumentRepository.findByName(name);
//		
//		theDocumentRepository.deleteById(theDocument.getId());
//	}
}
