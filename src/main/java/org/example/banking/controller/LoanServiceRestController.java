package org.example.banking.controller;

import javax.validation.Valid;

import org.example.banking.request.LoanRequest;
import org.example.banking.service.LoanService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequestMapping("/banking")
public class LoanServiceRestController {

  @Autowired
  private LoanService loanService;

  @GetMapping(value = "/loan/balance/{customerId}")
  public String getLoanBalance(@PathVariable("customerId") Long customerId){

    return loanService.getTotalLoanAmount(customerId);
  }

  @PostMapping(value = "/loan/create")
  public ResponseEntity<String> createLoan(@Valid @RequestBody LoanRequest loanRequest){
    try {
      loanService.createNewLoan(loanRequest.getLoanAmount(), Long.parseLong(loanRequest.getCustomerId()));
      return new ResponseEntity<>("Success", HttpStatus.OK);
    }
    catch (Exception e){
      //log
      return new ResponseEntity<>("Error", HttpStatus.SERVICE_UNAVAILABLE);
    }
  }

}
