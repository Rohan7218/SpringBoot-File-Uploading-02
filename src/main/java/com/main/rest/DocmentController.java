package com.main.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.main.entity.Document;
import com.main.service.DocumentService;

@RestController
@RequestMapping(value = "/api")
public class DocmentController 
{
	@Autowired
	private DocumentService documentService;
	
	@PostMapping(value = "/documents")
	public ResponseEntity<String> uploadDocuments(@RequestPart MultipartFile leavingCertificate,  @RequestPart MultipartFile finalMarksheet,
			@RequestPart MultipartFile castCertificate, @RequestPart MultipartFile bonafide,	@RequestPart MultipartFile passportPhoto)
	{
		Document document=new Document();
		try
		{
			document.setLeavingCertificate(leavingCertificate.getBytes());
			document.setFinalMarksheet(finalMarksheet.getBytes());
			document.setCastCertificate(castCertificate.getBytes());
			document.setBonafide(bonafide.getBytes());
			document.setPassportPhoto(passportPhoto.getBytes());
		
			String msg=documentService.uploadDocuments(document);
			return new ResponseEntity<String>(msg, HttpStatus.CREATED);
		}
		catch(Exception e)
		{
			System.out.println(e.getMessage());
			return new ResponseEntity<String>(HttpStatus.CREATED);
		}
	}
}
