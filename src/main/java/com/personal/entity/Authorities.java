package com.personal.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "Authorities")
public class Authorities {
  @Id @GeneratedValue private int authority_id;

  @Column(name = "email")
  private String email;

  @Column(name = "authority")
  private String authority;

  public int getAuthority_id() {
    return authority_id;
  }

  public void setAuthority_id(int authority_id) {
    this.authority_id = authority_id;
  }

  public String getEmail() {
    return email;
  }

  public void setEmail(String email) {
    this.email = email;
  }

  public String getAuthority() {
    return authority;
  }

  public void setAuthority(String authority) {
    this.authority = authority;
  }
}
