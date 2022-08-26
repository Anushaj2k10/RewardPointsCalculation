package com.customer.entity;

import javax.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Data
@NoArgsConstructor
@Entity
@Table(name = "CUSTOMERS")
public class Customer {

  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "ID")
  Integer Id;

  @Column(name = "FIRST_NAME")
  String firstName;

  @Column(name = "LAST_NAME")
  String lastName;

  @Column(name = "SEX")
  char sex;

  @Column(name = "CITY")
  String city;

  @Column(name = "ZIP")
  int zip;

  @Column(name = "ADDRESS")
  String address;
}
