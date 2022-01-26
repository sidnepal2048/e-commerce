package com.personal.dao;

import com.personal.entity.User;
import java.util.List;

public interface UserDao {
  void addUser(User user);

  List<User> getAllUser();

  User getUserByEmail(String email);
}
