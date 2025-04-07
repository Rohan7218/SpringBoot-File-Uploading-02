package com.main.serviceImpl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.main.entity.Document;
import com.main.repository.DocumentRepository;
import com.main.service.DocumentService;

@Service
public class DocumentServiceImpl implements DocumentService
{
	@Autowired
	private DocumentRepository documentRepository;
	
	@Override
	public String uploadDocuments(Document document) 
	{
		Document uploadedDocument = documentRepository.save(document);
		if(uploadedDocument!=null)
		{
			return "!!!...Document Uploaded SuccessFully...!!!";
		}
		else
		{
			return"!!!...Failed To Upload...!!!";
		}
	}
}
