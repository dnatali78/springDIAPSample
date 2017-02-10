package com.aurea.antipattern.sample.spring.bean;

import java.util.Date;

public class Component {

  private Long id;
  private String name;
  private String author;
  private Date createdAt;
  private boolean enabled;

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

  public String getAuthor() {
    return author;
  }

  public void setAuthor(String author) {
    this.author = author;
  }

  public Date getCreatedAt() {
    return createdAt;
  }

  public void setCreatedAt(Date createdAt) {
    this.createdAt = createdAt;
  }

  public boolean isEnabled() {
    return enabled;
  }

  public void setEnabled(boolean enabled) {
    this.enabled = enabled;
  }

  @Override
  public boolean equals(Object obj) {
    return super.equals(obj);
  }
  
  @Override
  public String toString() {
    return "Component:" + name;  
  }
  
  
}
