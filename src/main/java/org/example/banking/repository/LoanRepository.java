package org.example.banking.repository;

import java.util.List;

import org.example.banking.entity.Loan;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoanRepository extends JpaRepository<Loan, Long> {

  List<Loan> findAllByCustomerId(Long customerId);

}
