package com.personal.entity;

import javax.persistence.*;
import org.hibernate.annotations.Immutable;

@Entity(name = "CCTL_COUNTRY")
@Table(name = "CCTL_COUNTRY")
@Immutable
public class Country {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  @Column(name = "id", updatable = false, nullable = false)
  private Long id;

  @Column(name = "name")
  private String name;

  @Column(name = "retired")
  private int retired;

  public Country() {}

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public String getName() {
    return name;
  }

  public void setName(String name) {
    this.name = name;
  }

  public int getRetired() {
    return retired;
  }

  public void setRetired(int retired) {
    this.retired = retired;
  }
}
