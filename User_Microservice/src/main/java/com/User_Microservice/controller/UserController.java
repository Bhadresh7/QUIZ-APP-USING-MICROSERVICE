package com.User_Microservice.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.User_Microservice.model.Login;
import com.User_Microservice.model.User;
import com.User_Microservice.service.UserService;

@RestController
@CrossOrigin("http://localhost:3000")
@RequestMapping("/api/User")
public class UserController {

	@Autowired
	private UserService userService;
	
	@GetMapping("/get")
	public ResponseEntity<List<User>>getall(){
		
		List<User> user = userService.getall();
		return ResponseEntity.ok(user);
	}
	

	
	@PostMapping("/register")	
	public ResponseEntity<String>Registeration(@RequestBody User user)
	{
		String email=user.getEmail();
		if(userService.checkEmailExists(email) != null) {
			return ResponseEntity.badRequest().body("Email already exists");
		}
		else {
			userService.registerUser(user);
			String name=user.getUsername();
			return ResponseEntity.ok(name);
		}

	}
	//login
	@PostMapping("/login")
	public ResponseEntity<String> UserLogin(@RequestBody Login login){

		String email = login.getEmail();
		String password=login.getPassword();
		User user =userService.findbyEmail(email);
		if(user !=null && user.getPassword().equals(password)) {
			String name=user.getUsername();
			return ResponseEntity.ok(name);
		}
		else {

			return
					ResponseEntity.status(HttpStatus.UNAUTHORIZED).body("Check your email and password");
		}
	}
}