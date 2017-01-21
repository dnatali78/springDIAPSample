package com.aurea.antipattern.sample.spring;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.jdbc.core.JdbcTemplate;

import com.aurea.antipattern.sample.spring.bean.Status;
import com.aurea.antipattern.sample.spring.repository.StatusRepository;

@SpringBootApplication
@ImportResource("classpath:applicationContext.xml")
public class SpringDITestApplication {

  @Configuration
  public class DbConfiguration {
    
    @Value("${jdbc.driver}")
    private String driver;
    
    @Value("${jdbc.url}")
    private String url;
    
  }
  
  public static void main(String[] args) {
    SpringApplication.run(SpringDITestApplication.class, args);
  }

  @Autowired
  DataSource dataSource;

  @Bean
  public JdbcTemplate getJdbcTemplate() {
    return new JdbcTemplate(dataSource);
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
