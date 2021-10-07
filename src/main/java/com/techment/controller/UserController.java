package com.techment.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.techment.dto.UserDto;
import com.techment.entity.User;
import com.techment.service.IUserService;

@RestController
@RequestMapping("/userController")
public class UserController {

	@Autowired
	IUserService userService;
	
	@PostMapping("/registerUser")
	public ResponseEntity<UserDto> registerUser(@RequestBody User user) {
		UserDto dto =  userService.register(user);
		return new ResponseEntity<UserDto>(dto,HttpStatus.CREATED);
	}
	
	@PutMapping("/updateUser/{userId}")
	public ResponseEntity<String> updateUser(@RequestBody User user,@PathVariable int userId)
	{
		String Output = userService.updateUser(user, userId);
		return new ResponseEntity<String>(Output,HttpStatus.ACCEPTED);
	}
	
	@DeleteMapping("/deleteUser/{userId}")
	public ResponseEntity<String> deleteUser(@PathVariable int userId){
		
		
		return new ResponseEntity<String>(userService.deleteUser(userId),HttpStatus.OK);
	}
	
	@PostMapping("/validateUser")
	public ResponseEntity<UserDto> validate(@RequestBody User user){
		return new ResponseEntity<UserDto>(userService.validateUser(user),HttpStatus.OK);
	}
	
}
