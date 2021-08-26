package com.tcs.springbootdemo.controller;

import java.util.Optional;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
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
	private static final Logger logger = LoggerFactory.getLogger(UserController.class);
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
	private void saveUser(@RequestBody @Valid User user) {
		try {
			userservice.save(user);
		} catch (Exception e) {
			logger.error(e.getCause().toString());
		}		
	}
	@DeleteMapping("/{id}")
	public void deleteUser(@PathVariable("id") Integer id) {
		userservice.deleteUser(id);
	}
		
	
}
