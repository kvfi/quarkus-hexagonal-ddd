package com.acme.domain.model.loan;

import com.acme.domain.events.LoanStateChanged;
import com.acme.domain.model.user.UserId;
import com.acme.domain.shared.DomainEvent;
import com.acme.domain.shared.Entity;
import com.acme.domain.shared.RootAggregate;
import java.util.Date;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Setter
@Getter
public class Loan extends RootAggregate implements Entity<Loan> {
  private LoanId id;

  private LoanState state;

  private int numberOfYears;

  private long loanAmount;

  private double annualInterestRate;

  private Date loanDate;

  private UserId userId;

  @Override
  public boolean sameIdentityAs(Loan other) {
    return other != null && this.id.sameValueAs(other.getId());
  }

  public LoanState approveLoan() {
    state = LoanState.APPROVED;

    DomainEvent event =
        LoanStateChanged.builder().loanId(id).fromState(state).state(LoanState.APPROVED).build();

    registerEvent(event);

    return state;
  }

  public LoanState rejectLoan() {
    state = LoanState.REJECTED;

    DomainEvent event =
        LoanStateChanged.builder().loanId(id).fromState(state).state(LoanState.REJECTED).build();

    registerEvent(event);

    return state;
  }
}
