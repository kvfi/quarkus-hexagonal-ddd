package com.acme.infrastructure.events.kafka.outgoing;

import com.acme.domain.events.LoanStateChanged;
import com.acme.domain.ports.spi.EventBus;
import com.acme.domain.shared.DomainEvent;
import com.acme.infrastructure.events.kafka.LoanStateChangedArvo;
import jakarta.enterprise.context.ApplicationScoped;
import java.util.Collection;
import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.reactive.messaging.Channel;
import org.eclipse.microprofile.reactive.messaging.Emitter;

@ApplicationScoped
@Slf4j
public class LoanProducer implements EventBus {

  @Channel("loans-out")
  Emitter<LoanStateChangedArvo> emitter;

  @Override
  public void publish(Collection<DomainEvent> events) {
    log.debug("publish({})", events);
    events.forEach(
        event -> {
          LoanStateChanged loanEvent = ((LoanStateChanged) event);
          emitter.send(
              LoanStateChangedArvo.newBuilder()
                  .setEventId(loanEvent.getEventId().toString())
                  .setFromState(loanEvent.getFromState().toString())
                  .setOccurredOn(loanEvent.occurredOn().toString())
                  .setState(loanEvent.getState().toString())
                  .setLoanId(loanEvent.getLoanId().getId())
                  .build());
        });
  }
}
