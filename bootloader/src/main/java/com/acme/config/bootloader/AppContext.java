package com.acme.config.bootloader;

import com.acme.application.ports.api.LoanAPIService;
import com.acme.application.service.LoanAPIServiceImpl;
import com.acme.domain.model.loan.LoanFactory;
import com.acme.domain.ports.spi.EventBus;
import com.acme.domain.ports.spi.LoanRepository;
import jakarta.enterprise.inject.Produces;

public class AppContext {
  @Produces
  public LoanFactory loanFactory(LoanRepository loanRepository) {
    return new LoanFactory(loanRepository);
  }

  @Produces
  public LoanAPIService loanAPIService(
      LoanRepository loanRepository, EventBus eventBus, LoanFactory loanFactory) {
    return new LoanAPIServiceImpl(loanRepository, loanFactory, eventBus);
  }
}
