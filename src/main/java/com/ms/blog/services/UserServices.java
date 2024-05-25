package com.ms.blog.services;

import java.util.List;

import com.ms.blog.payloads.UserDto;


public interface UserServices {
	UserDto createUser(UserDto user);
	UserDto updateUser(UserDto user, Integer userId);
	UserDto getUserById(Integer userId);
	List<UserDto> getAllUsers();
	void deleteUsers(Integer id);
	
}
