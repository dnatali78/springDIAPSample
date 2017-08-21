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
	  System.out.println("Getting status for all components..");
   return statusRepository.findAll();
 }
  
  public Status getStatusByComponent(String component) {
	  
	  System.out.println("Find status for" + component);
	  
    return statusRepository.findByComponent(component);
  }
}
