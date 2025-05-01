package com.acme.infrastructure.events.kafka.incoming;

import com.acme.application.ports.commands.LoanStatusService;
import com.acme.domain.model.loan.LoanId;
import com.acme.infrastructure.events.kafka.LoanStateChangedArvo;
import jakarta.enterprise.context.ApplicationScoped;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.reactive.messaging.Incoming;

@ApplicationScoped
@Slf4j
public class LoanConsumer {
  LoanStatusService loanStatusService;

  @Incoming("loans-in")
  public void receive(LoanStateChangedArvo event) {
    log.info("Got a loan event: {}", event);

    LoanId loanId = LoanId.builder().id(event.getLoanId()).build();

    try {
      loanStatusService.approveLoan(loanId);
    } catch (RuntimeException e) {
      // TODO error logic
    }
  }
}
