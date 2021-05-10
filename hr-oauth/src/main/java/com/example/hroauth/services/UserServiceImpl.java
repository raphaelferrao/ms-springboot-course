package com.example.hroauth.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.example.hroauth.entities.User;
import com.example.hroauth.feignclients.UserFeignClient;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class UserServiceImpl implements UserService, UserDetailsService {
	
	@Autowired
	private UserFeignClient userFeignClient;
	
	@Override
	public User findByEmail(String email) {
		User user = userFeignClient.findByEmail(email).getBody();
		
		if (user == null) {
			log.error("Email {} not found", email);
			throw new IllegalArgumentException(String.format("Email %s not found", email));
		}
		
		log.info("Email {} found: {}", email, user);
		return user;
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		User user = userFeignClient.findByEmail(username).getBody();
		
		if (user == null) {
			log.error("User with email {} not found", username);
			throw new UsernameNotFoundException(String.format("User with email  %s not found", username));
		}
		
		log.info("User with mail {} found: {}", username, user);
		return user;
	}

}
