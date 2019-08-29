package com.personal.service;

import java.util.List;

import com.personal.entity.User;

public interface UserService {
	void addUser(User user);
	List<User> getAllUser();
	User getUserByEmail(String email);

}
