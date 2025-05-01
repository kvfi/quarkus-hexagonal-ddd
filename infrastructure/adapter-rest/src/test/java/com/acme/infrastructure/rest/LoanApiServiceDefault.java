package com.acme.infrastructure.rest;

import com.acme.application.ports.api.LoanAPIService;
import com.acme.domain.model.loan.Loan;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.List;

@ApplicationScoped
public class LoanApiServiceDefault implements LoanAPIService {

  @Override
  public Loan getLoan(String id) {
    return null;
  }

  @Override
  public List<Loan> getAllLoans() {
    // TODO Auto-generated method stub
    return null;
  }

  @Override
  public void deleteLoan(String id) {
    // TODO Auto-generated method stub

  }

  @Override
  public void create(Loan prop) {
    // TODO Auto-generated method stub

  }

  @Override
  public void update(Loan prop) {
    // TODO Auto-generated method stub

  }
}
