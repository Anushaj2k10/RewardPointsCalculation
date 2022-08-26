package com.customer.entity;

import java.math.BigDecimal;
import java.util.Date;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@Entity
@Table(name = "CUSTOMER_PURCHASE_HISTORY")
public class PurchaseHistory {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  Integer Id;

  @Column(name = "CUST_ID")
  Integer custId;

  @Column(name = "PURCHASE_CODE")
  String code;

  @Column(name = "PURCHASE_NUM")
  String num;

  @Column(name = "PURCHASE_AMOUNT")
  Double amount;

  @Column(name = "PURCHASE_DATE")
  Date date;
}
