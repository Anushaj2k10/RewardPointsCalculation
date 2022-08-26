package com.customer.repository;

import com.customer.entity.PurchaseHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerPurchaseHistory
    extends JpaRepository<PurchaseHistory, Integer>, CustomerPurchaseHistoryCustom {}
