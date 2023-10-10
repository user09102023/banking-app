package org.example.banking.entity;

import java.math.BigDecimal;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import lombok.Data;

@Entity
@Data
public class Loan {

  @Id
  @GeneratedValue(strategy = GenerationType.AUTO)
  Long loanId;

  Long customerId;

  BigDecimal loanAmount;
}
