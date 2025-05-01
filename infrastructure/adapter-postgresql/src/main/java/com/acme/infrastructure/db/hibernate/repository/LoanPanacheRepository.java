package com.acme.infrastructure.db.hibernate.repository;

import com.acme.infrastructure.db.hibernate.dbo.LoanEntity;
import io.quarkus.hibernate.orm.panache.PanacheRepositoryBase;
import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class LoanPanacheRepository implements PanacheRepositoryBase<LoanEntity, String> {}
