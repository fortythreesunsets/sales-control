package com.proyecto1.springboot.jpa.app.models.service;

import java.io.IOException;
import java.net.MalformedURLException;

import org.springframework.core.io.Resource;
import org.springframework.web.multipart.MultipartFile;

public interface IUploadFileService {
	
	public Resource load(String filename) throws MalformedURLException;
	
	public String copy(MultipartFile file) throws IOException;
	
	public boolean delete(String filename);
	
	//Borra las imágenes
	public void deleteAll();
	
	//Crea la carpeta uploads
	public void init() throws IOException;
}