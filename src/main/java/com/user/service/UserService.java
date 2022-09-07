package com.user.service;

import java.util.Optional;

import com.user.bean.User;

public interface UserService {
	Optional<User> getUserByEmail(String email);
	
	boolean addUser(User user);
}
