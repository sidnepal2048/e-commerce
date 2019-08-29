package com.personal.dao;

import java.util.List;

import com.personal.entity.User;

public interface UserDao {
	void addUser(User user);
	List<User> getAllUser();
	User getUserByEmail(String email);
}
