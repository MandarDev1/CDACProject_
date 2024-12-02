package com.mandardev.blog.services;

import java.util.List;

import com.mandardev.blog.payloads.CategoryDto;


public interface CategoryService {
	
	 //create 
		CategoryDto createCategory(CategoryDto categoryDto);// interface is by default public and abstract so we have not
															// written in these methods

	  //update
		CategoryDto updateCategory(CategoryDto categoryDto, Integer catagoryId);

	   //delete
		void deleteCategory(Integer categoryId);

	   //get
		CategoryDto getCategory(Integer categoryId);
		
	   //get All
		List<CategoryDto>getCategories();

}
