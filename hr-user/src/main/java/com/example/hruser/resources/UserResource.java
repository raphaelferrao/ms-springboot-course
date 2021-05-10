package com.example.hruser.resources;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.hruser.entities.User;
import com.example.hruser.services.UserService;

@RestController
@RequestMapping("/users")
public class UserResource {
	
	@Autowired
	private UserService userService;
	
	@GetMapping("/{id}")
	public ResponseEntity<User> findById(@PathVariable Long id){
		return ResponseEntity.ok(userService.findById(id));
	}
	
	@GetMapping("/search")
	public ResponseEntity<User> findById(@RequestParam String email){
		return ResponseEntity.ok(userService.findByEmail(email));
	}

}
