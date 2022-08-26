package com.customer;

import com.customer.entity.PurchaseHistory;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TestH2PurchaseHistoryRepository extends JpaRepository<PurchaseHistory,Integer> {

}
