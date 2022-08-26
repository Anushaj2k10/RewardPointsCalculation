package com.customer.services;

import com.customer.entity.Customer;
import com.customer.entity.PurchaseHistory;
import com.customer.repository.CustomerPurchaseHistory;
import com.customer.repository.CustomerRepository;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;
import org.springframework.stereotype.Service;

@Service
public class CustomerService {

  CustomerRepository customerRepository;
  CustomerPurchaseHistory customerPurchaseHistory;

  private CustomerService(
      CustomerRepository customerRepository, CustomerPurchaseHistory customerPurchaseHistory) {
    this.customerPurchaseHistory = customerPurchaseHistory;
    this.customerRepository = customerRepository;
  }

  public Double getRewardPoints(Long customerId) {

    Optional<Customer> customerAvailable = customerRepository.findById(customerId.intValue());

    if (customerAvailable.isPresent()) {

      // Get the start date 3 months back
      Calendar cal = Calendar.getInstance();
      cal.add(Calendar.MONTH, -3);
      Date recordsLimitDate = cal.getTime();

      List<PurchaseHistory> customersPurchaseHistoryList =
          customerPurchaseHistory.getPurchaseHistory(customerId.intValue(), recordsLimitDate);
      return calculateRewardPoints(customersPurchaseHistoryList);
    } else return null;
  }

  /*
    * To calculate the reward points of a customer with below logic
    * A customer receives 2 points for every dollar spent over $100 in each transaction, plus 1 point for every dollar spent over $50 in each transaction
      (e.g. a $120 purchase = 2x$20 + 1x$50 = 90 points).
    *@arg customerId
  */
  private Double calculateRewardPoints(List<PurchaseHistory> customersPurchaseHistoryList) {

    Double rewardPointsForAbove100 =
        customersPurchaseHistoryList.stream()
            .filter(customerPurchase -> (customerPurchase.getAmount() > 100))
            .mapToDouble(o -> (o.getAmount() - 100) * 2 + 50)
            .sum();
    Double rewardPointsForAbove50 =
        customersPurchaseHistoryList.stream()
            .filter(
                customerPurchase ->
                    (customerPurchase.getAmount() > 50
                        && customerPurchase.getAmount() <= 100))
            .mapToDouble(o -> (o.getAmount() - 50))
            .sum();

    return rewardPointsForAbove100 + rewardPointsForAbove50;
  }
}
