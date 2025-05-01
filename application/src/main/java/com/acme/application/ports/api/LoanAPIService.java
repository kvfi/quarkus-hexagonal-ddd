package com.acme.application.ports.api;

import com.acme.domain.model.loan.Loan;
import java.util.List;

public interface LoanAPIService {

  public Loan getLoan(String id);

  public List<Loan> getAllLoans();

  public void deleteLoan(String id);

  public void create(Loan prop);

  public void update(Loan prop);
}
