package com.example.hroauth.services;

import com.example.hroauth.entities.User;

public interface UserService {

	User findByEmail(String email);

}