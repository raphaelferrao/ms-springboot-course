package com.example.hruser.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.example.hruser.entities.User;

public interface UserRepository extends JpaRepository<User, Long>{
	
	public User findByEmail(String email);

}
