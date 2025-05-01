package com.acme.domain.events;

import com.acme.domain.model.loan.LoanId;
import com.acme.domain.model.loan.LoanState;
import com.acme.domain.shared.DomainEvent;
import java.time.Instant;
import java.util.UUID;
import lombok.Builder;
import lombok.Getter;
import lombok.ToString;

@Builder
@Getter
@ToString
public class LoanStateChanged implements DomainEvent {
  @Builder.Default private final UUID eventId = UUID.randomUUID();
  @Builder.Default private final Instant occurredOn = Instant.now();
  private final LoanId loanId;
  private final LoanState fromState;
  private final LoanState state;

  @Override
  public Instant occurredOn() {
    return occurredOn;
  }

  @Override
  public UUID eventId() {
    return eventId;
  }
}
