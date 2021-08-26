package com.tcs.springbootdemo.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.tcs.springbootdemo.User;
import com.tcs.springbootdemo.exception.UserNotFoundException;
import com.tcs.springbootdemo.repository.IUserRepository;

@Service
public class UserService implements IUserService{

	@Autowired
	IUserRepository userrepo;
	
	@Override
	@Transactional(rollbackFor = Exception.class)//Do rollback for all type of exception
	public void save(User user) throws Exception {
		userrepo.save(user);
		System.out.println("Called");
		throw new Exception();
		
	}
	
	@Override
	public Iterable<User> getAlluser() {
		return userrepo.findAll();
	}

	@Override
	public Optional<User> getUserById(Integer id) {
		Optional<User> user = userrepo.findById(id);
		if (!user.isPresent()) {
			throw new UserNotFoundException("user does not exist");
		}
		return user;
	}

	@Override
	public void deleteUser(Integer id) {
		userrepo.deleteById(id);
		
	}

	

}
