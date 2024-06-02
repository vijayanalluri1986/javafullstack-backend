package com.example.hexagonal_architecture_example.infrastructure.config.spring;


import com.example.hexagonal_architecture_example.application.repository.UserRepository;
import com.example.hexagonal_architecture_example.application.service.UserService;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SpringBootServiceConfig {

  @Bean
  public UserService userService(UserRepository userRepository) {
    return new UserService(userRepository);
  }
}