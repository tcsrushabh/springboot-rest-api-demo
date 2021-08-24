package com.tcs.springbootdemo;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserController {
	@GetMapping("/helloworld" )
	private String getUser() {
		System.out.println("Hello");
		return "hello";
	}
	@PostMapping("/user")
	private String saveUser(@RequestBody User user) {
		System.out.println(user.getName());
		return user.getName();
	}
}
