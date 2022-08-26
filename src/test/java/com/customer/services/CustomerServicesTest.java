package com.customer.services;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.customer.controllers.CustomerRewardsController;
import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;

@ExtendWith(SpringExtension.class)
@SpringBootTest
@AutoConfigureTestDatabase
public class CustomerServicesTest {
  @Autowired
  CustomerRewardsController customerRewardsController;

  @Test
  public void contextLoads() {
    Assertions.assertThat(customerRewardsController).isNot(null);
  }
}
