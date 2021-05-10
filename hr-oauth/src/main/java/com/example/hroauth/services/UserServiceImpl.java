package com.example.hroauth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.hroauth.entities.User;
import com.example.hroauth.feignclients.UserFeignClient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	@Override
	public User findByEmail(String email) {
		User user = userFeignClient.findByEmail(email).getBody();
		
		if (user == null) {
			log.error("Email {} not found", email);
			throw new IllegalArgumentException(String.format("Email %s not found", email));
		}
		
		log.info("Email {} found", email);
		return user;
	}

}
