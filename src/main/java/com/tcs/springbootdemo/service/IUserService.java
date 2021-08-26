package com.tcs.springbootdemo.service;

import java.util.Optional;

import com.tcs.springbootdemo.User;

public interface IUserService {
	void save(User user) throws Exception;
	Iterable<User> getAlluser();
	Optional<User>getUserById (Integer id);
	 void deleteUser(Integer id);
}
