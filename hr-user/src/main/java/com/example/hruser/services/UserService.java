package com.example.hruser.services;

import com.example.hruser.entities.User;

public interface UserService {

	User findByEmail(String email);

	User findById(Long id);

}