package com.aurea.antipattern.sample.spring.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.aurea.antipattern.sample.spring.bean.Status;
import com.aurea.antipattern.sample.spring.repository.StatusRepository;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class StatusService {

	@Autowired
	private StatusRepository statusRepository;

	public Iterable<Status> getStatusForAllComponents() {
		log.debug("Getting status for all components..");
		return statusRepository.findAll();
	}

	public Status getStatusByComponent(String component) {
		log.debug("Find status for" + component);
		return statusRepository.findByComponent(component);
	}
}
