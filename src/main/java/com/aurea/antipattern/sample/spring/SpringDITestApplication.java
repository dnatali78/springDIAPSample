package com.aurea.antipattern.sample.spring;

import java.util.Date;

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
    
    @Value("org.h2.Driver")
    private String driver;
    
    @Value("jdbc:h2:mem:stgdb;DB_CLOSE_DELAY=-1")
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
      repository.save(new Status("Component1", new Date() ));
      repository.save(new Status("Component2", new Date()));
      repository.save(new Status("Component3", new Date()));
      repository.save(new Status("Component4", new Date()));
      repository.save(new Status("Component5", new Date()));

    };
  }
}
