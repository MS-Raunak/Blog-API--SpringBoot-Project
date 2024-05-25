package com.ms.blog.payloads;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

/**
 * @NotNull,@Email is the part of bean validation and to enable this we have to use @valid in controller while posting and updating data
 * we use spring-boot-starter-validation dependency to use bean validation
 */
public class UserDto {
	
	private int id;
	
	
	@NotEmpty //It check blank and @NotNull both
	@Size(min=4, message = "User name must be min 4 characters!!")
	private String name;
	
	@Email(message = "email is not valid")
	private String email;
	
	@NotEmpty()
	@Size(min = 4, max = 10, message = "password must have min 4 and max 10 characters!!")
	private String password;
	
	@NotEmpty
	private String about;
	
	
	 public UserDto(int id, String name, String email, String password, String about) {
		super();
		this.id = id;
		this.name = name;
		this.email = email;
		this.password = password;
		this.about = about;
	}

	public UserDto() {
		// TODO Auto-generated constructor stub
	}
	
	public int getId() {
		return id;
	}
	public String getName() {
		return name;
	}
	public String getEmail() {
		return email;
	}
	public String getPassword() {
		return password;
	}
	public String getAbout() {
		return about;
	}
	
	public void setId(int id) {
		this.id = id;
	}
	public void setName(String name) {
		this.name = name;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setAbout(String about) {
		this.about = about;
	}
	
	
	
	
}
