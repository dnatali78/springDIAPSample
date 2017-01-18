package com.aurea.antipattern.sample.spring.services;

import org.springframework.stereotype.Service;

import com.aurea.antipattern.sample.spring.helper.ComponentHelper;

@Service
public class ComponentService {

  private final ComponentHelper helper;

  public ComponentService(ComponentHelper helper) {
    this.helper = helper;
  }

  public String getComponentDetails(String component) {
    return helper.findComponentDetails(component);
  }

}
