package com.User_Microservice.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.User_Microservice.model.User;

public interface UserRepo extends JpaRepository<User, Long>{
	User findByEmail(String email);
}