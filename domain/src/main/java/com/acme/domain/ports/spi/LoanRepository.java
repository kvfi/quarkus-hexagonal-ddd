package com.acme.domain.ports.spi;

import com.acme.domain.model.loan.Loan;
import java.util.List;

public interface LoanRepository {

  List<Loan> getAll();

  Loan findById(String id);

  void save(Loan prop);

  void update(Loan prop);

  void delete(String id);

  String nextLoanId();
}
