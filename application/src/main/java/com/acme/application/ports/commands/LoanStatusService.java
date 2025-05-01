package com.acme.application.ports.commands;

import com.acme.domain.model.loan.LoanId;

public interface LoanStatusService {

  public void approveLoan(LoanId loanId);

  public void rejectLoan(LoanId loanId);
}
