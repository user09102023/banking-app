package org.example.banking.service;

import java.math.BigDecimal;
import java.util.List;

import org.example.banking.entity.Loan;
import org.example.banking.exception.BankingException;
import org.example.banking.repository.LoanRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
public class LoanService {

  @Autowired
  private LoanRepository loanRepository;

  public String getTotalLoanAmount(Long customerId){
    List<Loan> loanList = loanRepository.findAllByCustomerId(customerId);
    if(loanList != null && loanList.size() > 0){
      return calcTotal(loanList);
    }
    return "0";
  }

  @Transactional
  public void createNewLoan(BigDecimal amount, Long customerId) throws BankingException {
    if(valueOutOfRange(amount)){
      throw new BankingException("Amount out of range");
    }
    Loan loan = new Loan();
    loan.setCustomerId(customerId);
    loan.setLoanAmount(amount);
    loanRepository.saveAndFlush(loan);
  }

  private String calcTotal(List<Loan> loanList){
    BigDecimal total = new BigDecimal(0);
    for(Loan loan : loanList){
      total = total.add(loan.getLoanAmount());
    }
    return total.toString();
  }

  private boolean valueOutOfRange(BigDecimal amount){
    if(amount == null) return true;
    if(amount.compareTo(new BigDecimal(500)) < 0) return true;
    if(amount.compareTo(new BigDecimal(12000.50)) > 0) return true;
    return false;
  }
}
