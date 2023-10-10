package org.example.banking.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.math.BigDecimal;

import org.example.banking.TestApplication;
import org.example.banking.entity.Loan;
import org.example.banking.exception.BankingException;
import org.example.banking.repository.LoanRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableTransactionManagement
@SpringBootTest(classes = TestApplication.class)
@ActiveProfiles("test")
@DirtiesContext(classMode = DirtiesContext.ClassMode.AFTER_EACH_TEST_METHOD)
public class LoanServiceIT {

  @Autowired
  private LoanService loanService;

  @Test
  public void test_get_total_loan_amount() throws Exception {
    loanService.createNewLoan(new BigDecimal(1000), 1L);
    loanService.createNewLoan(new BigDecimal(2000), 1L);
    loanService.createNewLoan(new BigDecimal(3000.25), 1L);
    String total = loanService.getTotalLoanAmount(1L);
    assertEquals("6000.25", total);
  }

  @Test
  public void test_create_loan_out_of_range() throws Exception {
    boolean flag = false;
    try {
      loanService.createNewLoan(new BigDecimal(12000.60), 1L);
    }
    catch (Exception e){
      if(e instanceof BankingException) flag = true;
    }
    assertTrue(flag);
  }

}
