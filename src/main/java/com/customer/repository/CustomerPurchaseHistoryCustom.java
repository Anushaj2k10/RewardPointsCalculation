package com.customer.repository;

import com.customer.entity.PurchaseHistory;
import java.util.Date;
import java.util.List;
import org.springframework.data.jpa.repository.Query;

public interface CustomerPurchaseHistoryCustom {

  @Query(
      value = "SELECT * FROM CUSTOMER_PURCHASE_HISTORY where CUST_ID = ?1 and PURCHASE_DATE >= ?2 ",
      nativeQuery = true)
  List<PurchaseHistory> getPurchaseHistory(int customerId, Date recordsLimitDate);
}
