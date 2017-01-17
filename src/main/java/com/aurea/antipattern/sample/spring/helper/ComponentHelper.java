package com.aurea.antipattern.sample.spring.helper;

import org.springframework.util.StringUtils;

public class ComponentHelper {

  public String findComponentDetails(String component) {
    return StringUtils.uncapitalize(component);
  }
  
}
