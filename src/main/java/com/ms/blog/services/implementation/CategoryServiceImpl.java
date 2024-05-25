package com.ms.blog.services.implementation;

import java.util.List;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.blog.entities.Category;
import com.ms.blog.exceptions.ResourceNotFoundException;
import com.ms.blog.payloads.CategoryDto;
import com.ms.blog.repositories.CategoryRepo;
import com.ms.blog.services.CategoryService;

@Service
public class CategoryServiceImpl implements CategoryService {
	@Autowired
	private CategoryRepo categoryRepo;
	@Autowired
	private ModelMapper modelMapper; //modelMApper is using to convert dto to categ and categ to dto
	
	@Override
	public CategoryDto createCategory(CategoryDto categoryDto) {
		Category category = this.modelMapper.map(categoryDto, Category.class); //dto to category
		Category addedCategory = this.categoryRepo.save(category);
		return this.modelMapper.map(addedCategory, CategoryDto.class);
	}

	@Override
	public CategoryDto updateCategory(CategoryDto categoryDto, Integer catagoryId) {
		Category category = this.categoryRepo.findById(catagoryId).orElseThrow(() -> 
		new ResourceNotFoundException("Category", "Category Id", catagoryId));
		
		category.setCategoryTitle(categoryDto.getCategoryTitle());
		category.setCategoryDescription(categoryDto.getCategoryDescription());
		
		Category updatedCategory = this.categoryRepo.save(category);
		CategoryDto catDto = this.modelMapper.map(updatedCategory, CategoryDto.class);
		return catDto;
	}

	@Override
	public void deleteCategory(Integer catagoryId) {
		Category category = this.categoryRepo.findById(catagoryId).orElseThrow(()-> 
		new ResourceNotFoundException("Category", "Category Id", catagoryId));
		
		this.categoryRepo.delete(category);

	}

	@Override
	public CategoryDto getCategoryById(Integer catagoryId) {
		Category category = this.categoryRepo.findById(catagoryId).orElseThrow(()->
		new ResourceNotFoundException("Category", "Category Id", catagoryId));
		return this.modelMapper.map(category, CategoryDto.class);
	}

	@Override
	public List<CategoryDto> getAllCategories() {
		List<Category> categories = this.categoryRepo.findAll();
		List<CategoryDto> categoryDtos = categories.stream().map((category)-> this.modelMapper.map(category, CategoryDto.class)).collect(Collectors.toList());
		return null;
	}

}
