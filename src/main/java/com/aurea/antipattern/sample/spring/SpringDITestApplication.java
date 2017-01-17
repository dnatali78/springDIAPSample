package com.aurea.antipattern.sample.spring;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ImportResource;

import com.aurea.antipattern.sample.spring.bean.Status;
import com.aurea.antipattern.sample.spring.repository.StatusRepository;

@SpringBootApplication
@ImportResource("classpath:applicationContext.xml")
public class SpringDITestApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringDITestApplication.class, args);
	}
	
	@Bean
    public CommandLineRunner demo(StatusRepository repository) {
        return (args) -> {
            repository.save(new Status("Component1", "OK"));
            repository.save(new Status("Component2", "OK"));
            repository.save(new Status("Component3", "OK"));
            repository.save(new Status("Component4", "IN PROGRESS"));
            repository.save(new Status("Component5", "FAILURE"));

        };
    }
}
