package com.acme.domain.model.loan;

import com.acme.domain.events.LoanStateChanged;
import com.acme.domain.model.user.UserId;
import com.acme.domain.ports.spi.LoanRepository;
import com.acme.domain.shared.DomainEvent;
import java.util.Date;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@AllArgsConstructor
@Slf4j
public class LoanFactory {
  private LoanRepository loanRepository;

  public Loan createLoan(Loan loan) {
    return createLoan(
        loan.getNumberOfYears(),
        loan.getLoanAmount(),
        loan.getAnnualInterestRate(),
        loan.getLoanDate(),
        loan.getUserId());
  }

  public Loan createLoan(
      int numberOfYears, long loanAmount, double annualInterestRate, Date date, UserId userId) {
    log.debug(
        "createLoan({},{},{},{},{},{})",
        numberOfYears,
        loanAmount,
        annualInterestRate,
        date,
        userId);

    String nextLoanId = loanRepository.nextLoanId();

    LoanId loanId = LoanId.builder().id(nextLoanId).build();

    Loan loan =
        Loan.builder()
            .annualInterestRate(annualInterestRate)
            .loanAmount(loanAmount)
            .loanDate(date)
            .userId(userId)
            .numberOfYears(numberOfYears)
            .id(loanId)
            .state(LoanState.PENDING)
            .build();

    DomainEvent event =
        LoanStateChanged.builder()
            .loanId(loanId)
            .fromState(LoanState.PENDING)
            .state(LoanState.PENDING)
            .build();

    loan.registerEvent(event);

    return loan;
  }
}
