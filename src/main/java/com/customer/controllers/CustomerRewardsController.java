package com.customer.controllers;

import com.customer.services.CustomerService;
import lombok.extern.log4j.Log4j2;
import org.apache.commons.lang3.ObjectUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Log4j2
public class CustomerRewardsController {
  CustomerService customerService;

  public CustomerRewardsController(CustomerService customerService) {
    this.customerService = customerService;
  }

  @GetMapping("/{customerId}")
  public ResponseEntity<String> getRewardPoints(@PathVariable("customerId") String customerID) {
    if (StringUtils.equals("null", customerID) || StringUtils.isBlank(customerID)) {
      return new ResponseEntity<>("Customer Id cannot be null or empty", HttpStatus.BAD_REQUEST);
    } else {
      log.info("Calculating Reward Points for the customer :: {}", customerID);
      Long customerId = Long.parseLong(customerID);
      if (customerService.getRewardPoints(customerId) == null)
        return new ResponseEntity<>(
            "Customer Id " + customerId + " not found", HttpStatus.NOT_FOUND);
      else if (!ObjectUtils.isEmpty(customerService.getRewardPoints(customerId)))
        return ResponseEntity.ok(
            "Rewards points awarded to customer "
                + customerId
                + " are "
                + customerService.getRewardPoints(customerId));
    }

    return new ResponseEntity<>(
        "Error occurred while fetching reward points internally ",
        HttpStatus.INTERNAL_SERVER_ERROR);
  }
}
