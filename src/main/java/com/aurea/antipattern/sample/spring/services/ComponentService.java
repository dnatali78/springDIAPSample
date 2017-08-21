package com.aurea.antipattern.sample.spring.services;

import org.springframework.stereotype.Service;

import com.aurea.antipattern.sample.spring.bean.Component;
import com.aurea.antipattern.sample.spring.helper.ComponentHelper;
import com.aurea.antipattern.sample.spring.repository.ComponentRepository;

import lombok.extern.log4j.Log4j;

@Service
@Log4j
public class ComponentService {

	private ComponentHelper helper;
	private ComponentRepository compomentRepository;

	public void setHelper(ComponentHelper helper) {
		this.helper = helper;
	}

	public ComponentHelper getHelper() {
		return helper;
	}

	public String getComponentDetails(String component) {
		log.debug("Entering component details method");
		log.debug("Trying to find" + component + " details.");

		return helper.findComponentDetails(component);
	}

	public void saveComponent(Component component) {
		log.debug("Saving component");
		compomentRepository.save(component);
	}

}
