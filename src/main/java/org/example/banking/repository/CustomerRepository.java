package org.example.banking.repository;

import java.util.List;

import org.example.banking.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

  Customer findCustomerByCustomerId(Long customerId);

}
