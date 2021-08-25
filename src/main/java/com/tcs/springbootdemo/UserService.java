package com.tcs.springbootdemo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserService implements IUserService{

	@Autowired
	IUserRepository userrepo;
	
	@Override
	public void save(User user) {
		userrepo.save(user);
		System.out.println("Called");
		
	}
	
	@Override
	public Iterable<User> getAlluser(User user) {
		return userrepo.findAll();
	}

}
