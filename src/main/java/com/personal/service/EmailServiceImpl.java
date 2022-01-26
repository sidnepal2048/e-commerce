package com.personal.service;

import com.personal.dao.SendEmailDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class EmailServiceImpl implements EmailService {
  @Autowired private SendEmailDao emailDao;

  @Override
  public void sendEmailToUser(String to, String subject, String message) {
    emailDao.sendEmailToUser(to, subject, message);
  }
}
