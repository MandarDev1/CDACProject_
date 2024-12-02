package com.mandardev.blog.services;

import java.io.FileNotFoundException;


public interface FileService {
	

	String uploadImage(String path,MultipartFile file)throws IOException;
	
	InputStream getResource(String path,String fileName)throws FileNotFoundException;

}
