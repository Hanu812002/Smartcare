package com.healthcareservices.entity;


import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name="document")
public class Document {

	@Id
	@Column(name="document_id")
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private int id;
	
	@Column(name="doc_date")
	private String date;
	
	@Column(name="doc_type")
	private String documentType;
	
	@Column(name="description")
	private String description;
	
	@Column(name="file")
	private String file;

	public Document(String date, String documentType, String description, String file) {
		super();
		this.date = date;
		this.documentType = documentType;
		this.description = description;
		this.file = file;
	}

	public Document() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDate() {
		return date;
	}

	public void setDate(String date) {
		this.date = date;
	}

	public String getDocumentType() {
		return documentType;
	}

	public void setDocumentType(String documentType) {
		this.documentType = documentType;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	public String getFile() {
		return file;
	}

	public void setFile(String file) {
		this.file = file;
	}

	@Override
	public String toString() {
		return "Document [id=" + id + ", date=" + date + ", documentType=" + documentType + ", description="
				+ description + ", file=" + file + "]";
	}

	
}
