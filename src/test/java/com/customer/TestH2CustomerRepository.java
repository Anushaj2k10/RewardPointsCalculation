package com.customer;

import com.customer.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestH2CustomerRepository extends JpaRepository<Customer,Integer> {

}
