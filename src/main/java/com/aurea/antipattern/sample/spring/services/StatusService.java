package com.aurea.antipattern.sample.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurea.antipattern.sample.spring.bean.Status;
import com.aurea.antipattern.sample.spring.repository.StatusRepository;

@Service
public class StatusService {

  @Autowired
  private StatusRepository statusRepository;
  
  public Iterable<Status> getStatusForAllComponents() {
   return statusRepository.findAll();
 }
  
  public Status getStatusByComponent(String component) {
    return statusRepository.findByComponent(component);
  }
}
