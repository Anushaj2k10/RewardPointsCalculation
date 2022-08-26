package com.customer.rewards;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@ComponentScan(basePackages = {"com.customer.*"})
@EntityScan("com.customer.entity")
@EnableJpaRepositories({"com.customer.repository"})
public class RewardsApplication {

  public static void main(String[] args) {
    SpringApplication.run(RewardsApplication.class, args);
  }
}
