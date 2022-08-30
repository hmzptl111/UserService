package com.user.service;

import com.user.bean.User;

public interface UserService {
	User getUserByEmail(String email);
	
	boolean addUser(User user);
}
