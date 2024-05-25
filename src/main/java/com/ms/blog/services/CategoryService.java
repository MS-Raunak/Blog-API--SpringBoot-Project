package com.ms.blog.services;

import java.util.List;

import com.ms.blog.payloads.CategoryDto;


public interface CategoryService {
	
	CategoryDto createCategory(CategoryDto categoryDto);
	CategoryDto updateCategory(CategoryDto categoryDto, Integer catagoryId);
	void deleteCategory(Integer catagoryId);
	CategoryDto getCategoryById(Integer catagoryId);
	List<CategoryDto> getAllCategories();
}
