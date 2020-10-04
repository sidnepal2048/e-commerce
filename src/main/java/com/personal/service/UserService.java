package com.personal.service;

import java.util.List;

import com.personal.entity.User;

public interface UserService {
	User addUser(User user);
	List<User> getAllUser();
	User getUserByEmail(String email);

}
