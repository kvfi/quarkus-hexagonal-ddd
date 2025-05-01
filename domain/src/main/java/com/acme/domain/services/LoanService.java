package com.acme.domain.services;

import com.acme.domain.model.loan.Loan;
import com.acme.domain.model.loan.LoanId;
import com.acme.domain.ports.spi.EventBus;
import com.acme.domain.ports.spi.LoanRepository;

public class LoanService {
  EventBus eventBus;
  LoanRepository loanRepository;

  public Loan approveLoan(LoanId loanId) {
    Loan loan = loanRepository.findById(loanId.getId());

    loan.approveLoan();

    loanRepository.save(loan);

    eventBus.publish(loan.domainEvents());

    return loan;
  }
}
