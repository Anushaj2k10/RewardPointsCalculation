package com.customer.controllers;

import static org.junit.jupiter.api.Assertions.assertEquals;

import com.customer.DatabaseTestConfig;
import org.aspectj.lang.annotation.After;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.context.SpringBootTest.WebEnvironment;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.annotation.DirtiesContext.ClassMode;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.web.client.RestTemplate;

@SpringBootTest(
    webEnvironment = WebEnvironment.RANDOM_PORT,
    classes = com.customer.rewards.RewardsApplication.class)
@ContextConfiguration(classes = DatabaseTestConfig.class)
@DirtiesContext(classMode = ClassMode.BEFORE_EACH_TEST_METHOD)
class CustomerRewardsControllerTest {
  private static RestTemplate restTemplate;
  private String BASE_URL = "http://localhost";
  @LocalServerPort private int port;

  @BeforeAll
  public static void init() {
    restTemplate = new RestTemplate();
  }

  @BeforeEach
  public void setup() {
    BASE_URL = BASE_URL.concat(":").concat(port + "").concat("/rewards/");
  }

  @Test
  @DisplayName("To test reward points of customer with id:1000 ")
  public void testRewardPointsFor1000() {
    String responseEntity = restTemplate.getForObject(BASE_URL.concat("1000"), String.class);
    assertEquals("Rewards points awarded to customer 1000 are 310.0", responseEntity);
  }

  @Test
  @DisplayName("To test reward points of customer with id:1002 ")
  public void testRewardPointsFor1002() {
    String responseEntity = restTemplate.getForObject(BASE_URL.concat("1002"), String.class);
    assertEquals("Rewards points awarded to customer 1002 are 156.0", responseEntity);
  }

  @Test
  @DisplayName("To test reward points of customer with id:1003 ")
  public void testRewardPointsFor1003() {
    String responseEntity = restTemplate.getForObject(BASE_URL.concat("1003"), String.class);
    assertEquals("Rewards points awarded to customer 1003 are 92.0", responseEntity);
  }

  @Test
  @DisplayName("To test reward points of customer with id:null ")
  public void testRewardPointsForNull() {
    String responseEntity = restTemplate.getForObject(BASE_URL.concat("null"), String.class);
    assertEquals("Customer Id cannot be null or empty", responseEntity);
  }

  @Test
  @DisplayName("To test reward points of customer with id:19000 ")
  public void testRewardPointsForUnknownId() {
    String responseEntity = restTemplate.getForObject(BASE_URL.concat("19000"), String.class);
    assertEquals("Customer Id 19000 not found", responseEntity);
  }

  @After("")
  public void tearDown() {
    restTemplate = null;
  }
}
