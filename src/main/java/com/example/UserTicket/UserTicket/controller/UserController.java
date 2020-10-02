package com.example.UserTicket.UserTicket.controller;

import java.util.List;
import java.util.Optional;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.UserTicket.UserTicket.entity.User;
import com.example.UserTicket.UserTicket.exception.UserNotFoundException;
import com.example.UserTicket.UserTicket.repository.UserRepository;

@RestController
public class UserController {
	
	@Autowired
	private UserRepository repository;
	
	@GetMapping(path="/user")
	public List<User> showUserDetails(){
		return repository.findAll();
	}
	@PostMapping(path="/user")
	public User addUser(@Valid @RequestBody User user){
		return repository.save(user);
	}
	@GetMapping(path="/user/{id}")
	public Optional<User> retreiveSingleUser(@PathVariable int id){
		Optional<User> user =  repository.findById(id);
		if(!user.isPresent()){
			throw new UserNotFoundException("NO USER FOUND WITH GIVEN ID");
		}
		else{
			return user;
		}
	}
}
