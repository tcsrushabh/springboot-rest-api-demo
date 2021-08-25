package com.tcs.springbootdemo.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tcs.springbootdemo.User;
import com.tcs.springbootdemo.exception.UserNotFoundException;
import com.tcs.springbootdemo.service.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	@Autowired
	private UserService userservice;
	
	@GetMapping("/{id}" )
	private Optional<User> getUserById(@PathVariable Integer id ){
		return userservice.getUserById(id);
	}
	@ExceptionHandler(value =  { UserNotFoundException.class, IllegalStateException.class ,EmptyResultDataAccessException.class})
	public ResponseEntity<User> exception(Exception userNotFoundException) {
	    return new ResponseEntity<User>(HttpStatus.NOT_FOUND);
	}
	
	@GetMapping()
	private Iterable<User> getUser() {
		return userservice.getAlluser();
	}
	@PostMapping()
	private void saveUser(@RequestBody User user) {
		userservice.save(user);		
	}
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") Integer id) {
		userservice.deleteUser(id);
	}
		
	
}
