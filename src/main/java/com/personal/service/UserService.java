package com.personal.service;

import com.personal.entity.User;
import java.util.List;

public interface UserService {
  User addUser(User user);

  List<User> getAllUser();

  User getUserByEmail(String email);
}
