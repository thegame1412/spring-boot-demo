package com.user.service;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.user.dao.UserRepository;
import com.user.model.User;
import com.user.model.UserRegisterRequest;
import com.user.model.UserRegisterResponse;

@Service
public class UserService {

	@Autowired
	UserRepository repository;
	
	@Autowired
	User user;
	
	@Autowired 
	UserRegisterResponse registerResponse;
	
	public UserRegisterResponse registerUser(UserRegisterRequest registerRequest) {
		BeanUtils.copyProperties(registerRequest, user);
		BeanUtils.copyProperties(repository.save(user),registerResponse);
		return registerResponse;
	}
}
