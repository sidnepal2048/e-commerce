package com.personal.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.personal.dao.UserDao;
import com.personal.entity.User;
@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	@Override
	public User addUser(User user) {
		userDao.addUser(user);
		return user;
	}
	@Override
	public List<User> getAllUser() {
		return userDao.getAllUser();
	}
	@Override
	public User getUserByEmail(String email) {
		return userDao.getUserByEmail(email);
	}

}
