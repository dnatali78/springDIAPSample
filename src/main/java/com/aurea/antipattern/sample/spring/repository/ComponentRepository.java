package com.aurea.antipattern.sample.spring.repository;

import org.springframework.data.repository.CrudRepository;

import com.aurea.antipattern.sample.spring.bean.Component;

public interface ComponentRepository extends CrudRepository<Component, Long> {
  
}
