package com.ms.blog.payloads;

public class CategoryDto {
	private Integer categoryId;
	private String categoryTitle;
	private String categoryDescription;
	
	//default constructor
	public CategoryDto() {
		super();
		// TODO Auto-generated constructor stub
	}

	//parameterized constructor
	public CategoryDto(Integer categoryId, String categoryTitle, String categoryDescription) {
		super();
		this.categoryId = categoryId;
		this.categoryTitle = categoryTitle;
		this.categoryDescription = categoryDescription;
	}

	
	//Getter and Setter Method
	public Integer getCategoryId() {
		return categoryId;
	}

	public void setCategoryId(Integer categoryId) {
		this.categoryId = categoryId;
	}

	public String getCategoryTitle() {
		return categoryTitle;
	}

	public void setCategoryTitle(String categoryTitle) {
		this.categoryTitle = categoryTitle;
	}

	public String getCategoryDescription() {
		return categoryDescription;
	}

	public void setCategoryDescription(String categoryDescription) {
		this.categoryDescription = categoryDescription;
	}
	
	
	
}
