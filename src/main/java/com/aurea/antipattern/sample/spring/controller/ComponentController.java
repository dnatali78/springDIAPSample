package com.aurea.antipattern.sample.spring.controller;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.aurea.antipattern.sample.spring.services.ComponentService;
import com.aurea.antipattern.sample.spring.services.StatusService;

@RestController
public class ComponentController {

  private final StatusService statusService;

  private final ComponentService componentService;

  public ComponentController(ComponentService componentService, StatusService statusService) {
    this.componentService = componentService;
    this.statusService = statusService;
  }

  @RequestMapping("/allcomponents")
  public List<String> allcomponents() {
    return StreamSupport.stream(statusService.getStatusForAllComponents().spliterator(), false)
        .map(s -> componentService.getComponentDetails(s.getComponent())).collect(Collectors.toList());
  }

}
