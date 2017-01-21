package com.aurea.antipattern.sample.spring.bean;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity
public class Status {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  private Long id;

  private String component;
  private String state;

  protected Status() {}

  public Status(String component, String state) {
    this.component = component;
    this.state = state;
  }
  
  public Status(String component, Integer stateValue) {
    this.component = component;
}

  @Override
  public String toString() {
    return String.format("Status[id=%d, component='%s', state='%s']", id, component, state);
  }

  public String getComponent() {
    return component;
  }

  public String getState() {
    return state;
  }

}
