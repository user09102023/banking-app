package org.example.banking.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Customer {
  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  Long customerId;
  String fullName;

}