package com.user.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.stereotype.Service;

import com.user.bean.User;
import com.user.persistence.UserDao;

@Service
public class UserServiceImpl implements UserService {
	@Autowired
	private UserDao userDao;

	@Override
	public Optional<User> getUserByEmail(String email) {
		return userDao.findByEmail(email);
	}

	@Override
	public boolean addUser(User user) {
		int rows = 0;
		try {
			rows = userDao.addUser(user.getEmail(), user.getName(), user.getContact());			
		} catch(DataIntegrityViolationException dive) {
			System.out.println("Data integrity violated");
		} catch(Exception e) {
			System.out.println("Something went wrong");
		}
		
		return rows > 0;
	}
}