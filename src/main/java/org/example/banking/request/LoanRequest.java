package org.example.banking.request;

import java.math.BigDecimal;

import javax.validation.constraints.DecimalMax;
import javax.validation.constraints.DecimalMin;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;

import org.springframework.format.annotation.NumberFormat;

import lombok.Data;
import lombok.ToString;

@Data
@ToString
public class LoanRequest {

  @NotBlank
  @NumberFormat
  private String customerId;
  @NotNull
  @DecimalMin(value = "500.00")
  @DecimalMax(value = "12000.50")
  private BigDecimal loanAmount;
  @NotBlank
  private String customerName;

}
