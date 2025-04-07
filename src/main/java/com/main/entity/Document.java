package com.main.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Lob;

import lombok.Data;
@Entity
@Data
public class Document 
{
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer docId;
	
	@Lob
	private byte[] leavingCertificate;
	@Lob
	private byte[] finalMarksheet;
	@Lob
	private byte[] castCertificate;
	@Lob
	private byte[] bonafide;
	@Lob
	private byte[] passportPhoto;
	
	
}
