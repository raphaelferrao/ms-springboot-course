package com.example.hruser.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hruser.entities.User;
import com.example.hruser.repositories.UserRepository;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public User findByEmail(String email) {
		return userRepository.findByEmail(email);
	}
	
	@Override
	public User findById(Long id) {
		User obj = userRepository.findById(id).get();
		return obj;
	}
	
}
