package com.acme.domain.ports.spi;

import com.acme.domain.shared.DomainEvent;
import java.util.Collection;

public interface EventBus {
  void publish(final Collection<DomainEvent> events);
}
