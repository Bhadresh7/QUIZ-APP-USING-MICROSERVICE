package com.User_Microservice.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.User_Microservice.repository.UserRepo;

import com.User_Microservice.model.User;

@Service
public class UserService {

	@Autowired
	private UserRepo UserRepo;
	
	    public User checkEmailExists(String email) {
	        return UserRepo.findByEmail(email);
	    }

	  
	    public void registerUser(User user) {
	    	UserRepo.save(user);
	    }

	  
	    public User findbyEmail(String email) {
	        return UserRepo.findByEmail(email);
	    }
	    
	    public List<User> getall() {
	    	return UserRepo.findAll();
	    }
}
