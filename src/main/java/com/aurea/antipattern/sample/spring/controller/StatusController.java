package com.aurea.antipattern.sample.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.aurea.antipattern.sample.spring.bean.Status;
import com.aurea.antipattern.sample.spring.services.StatusService;

@RestController
public class StatusController {
  
  @Autowired
  private StatusService statusService;
  
  
  @RequestMapping("/allstatus")
  public Iterable<Status> allstatus() {
      return statusService.getStatusForAllComponents();
  }
  
  @RequestMapping("/status")
  public Status status(@RequestParam(value="component") String component) {
      return statusService.getStatusByComponent(component);
  }

}
