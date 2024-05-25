package com.ms.blog.services.implementation;

import java.util.List;
import java.util.stream.Collectors;

import com.ms.blog.exceptions.*;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ms.blog.entities.User;
import com.ms.blog.payloads.UserDto;
import com.ms.blog.repositories.UserRepo;
import com.ms.blog.services.UserServices;


@Service
public class UserServiceImpl implements UserServices{

	@Autowired
	UserRepo userRepo;
	
	@Autowired
	ModelMapper modelMapper;
	
	@Override
	public UserDto createUser(UserDto userDto) {
		System.out.println(userRepo);
		User user = this.dtoToUser(userDto);
		User savedUser = this.userRepo.save(user);
		return this.userToDto(savedUser);
	}

	@Override
	public UserDto updateUser(UserDto userDto, Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", " Id ", userId));
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());
		
		User updatedUSer = this.userRepo.save(user);
		UserDto userDto1 = this.userToDto(updatedUSer);
		
		return userDto1;
	}

	@Override
	public UserDto getUserById(Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User", " Id ", userId));
		return this.userToDto(user);
	}

	@Override
	public List<UserDto> getAllUsers() {
		List<User> list = this.userRepo.findAll();
		List<UserDto> userDtos = list.stream().map(user-> this.userToDto(user)).collect(Collectors.toList());
		return userDtos;
	}

	@Override
	public void deleteUsers(Integer userId) {
		User user = this.userRepo.findById(userId).orElseThrow(()-> new ResourceNotFoundException("User", " Id ", userId));
		this.userRepo.delete(user);
		
	}
	
	
	//Converting UserDto class to User class
	private User dtoToUser(UserDto userDto) {
		
		/*
		 * //without using ModelMapper library
		User user = new User();
		user.setId(userDto.getId());
		user.setName(userDto.getName());
		user.setEmail(userDto.getEmail());
		user.setPassword(userDto.getPassword());
		user.setAbout(userDto.getAbout());;
		return user;
		*/
		
		//With using ModelMapper library
		User user = modelMapper.map(userDto, User.class);
		return user;
		
	}
	
	//Converting User class to UserDto  class
	private UserDto userToDto(User user) {
		
		/*
		 * //without using ModelMapper library
		 UserDto userDto = new UserDto();
		userDto.setId(user.getId());
		userDto.setName(user.getName());
		userDto.setEmail(user.getEmail());
		userDto.setPassword(user.getPassword());
		userDto.setAbout(user.getAbout());;
		
		return userDto;
		 */
		
		//With using ModelMapper library
		UserDto userDto = modelMapper.map(user, UserDto.class);
		return userDto;
		
	}

}
