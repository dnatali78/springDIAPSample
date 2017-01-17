package com.aurea.antipattern.sample.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.aurea.antipattern.sample.spring.bean.Status;

public interface StatusRepository extends CrudRepository<Status, Long> {
  
  Status findByComponent(String component);
}
