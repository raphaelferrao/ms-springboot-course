package com.example.hroauth.services;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import com.example.hroauth.entities.User;

public interface UserService {

	User findByEmail(String email);

	UserDetails loadUserByUsername(String username) throws UsernameNotFoundException;
	
}