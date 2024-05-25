package com.ms.blog.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ms.blog.payloads.ApiResponse;
import com.ms.blog.payloads.UserDto;
import com.ms.blog.services.UserServices;

import jakarta.validation.Valid;
 
/**
 * @Valid is using here to enable @bean definition so that we could not insert or update blank or unwanted data.
 * We use @NotNull, @Email on the bean properties to avoid this things
 */
@RestController
@RequestMapping("/api/users")
public class UserController {
	@Autowired
	UserServices userService;
	
	//POST:- CREATE USER
	@PostMapping("/")
	public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
		UserDto createUserDto = this.userService.createUser(userDto);
		
		return new ResponseEntity<UserDto>(createUserDto, HttpStatus.CREATED);
		
	}
	
	
	//PUT:- UPDATE USER
	@PutMapping("/{userId}")
	public ResponseEntity<UserDto> updateUser(@Valid @RequestBody UserDto userDto, @PathVariable("userId") Integer uId) {
		UserDto updatedUSer =  this.userService.updateUser(userDto, uId);
		return ResponseEntity.ok(updatedUSer);
		//if id not found then custom exception message will get
	}
	
	//Delete:- Delete USer
	@DeleteMapping("/{userId}")
	public ResponseEntity<ApiResponse> deleteUSer(@PathVariable("userId") Integer id) {
		this.userService.deleteUsers(id);
		return new ResponseEntity<ApiResponse>(new ApiResponse("user deleted successfully", true), HttpStatus.OK);
		//if id not found then custom exception message will get
	}
	
	//GET:- GET All User
	@GetMapping("/")
	public ResponseEntity<List<UserDto>> getUser() {
		return ResponseEntity.ok(this.userService.getAllUsers());//if id not found then custom exception message will get
	}
	
	//GET:- GET Single User
		@GetMapping("/{userId}")
		public ResponseEntity<UserDto> getUser(@PathVariable("userId") Integer id) {
			return ResponseEntity.ok(this.userService.getUserById(id));
		}
}
