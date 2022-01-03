package com.user.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.user.model.UserRegisterRequest;
import com.user.model.UserRegisterResponse;
import com.user.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	UserRegisterResponse registerResponse;
	
	@GetMapping("/register")
	public ResponseEntity<UserRegisterResponse> registerUser(@RequestBody UserRegisterRequest registerRequest) {
		registerResponse = userService.registerUser(registerRequest);
		new ResponseEntity<>(HttpStatus.CREATED);
		return ResponseEntity.ok(registerResponse);
	}
}
