package com.personal.dao;

public interface SendEmailDao {
  public void sendEmailToUser(String to, String subject, String message);
}
