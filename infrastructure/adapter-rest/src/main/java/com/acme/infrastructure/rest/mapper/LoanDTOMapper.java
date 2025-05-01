package com.acme.infrastructure.rest.mapper;

import com.acme.domain.model.loan.Loan;
import com.acme.infrastructure.rest.dto.LoanDTO;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "cdi")
public interface LoanDTOMapper {

  @Mapping(source = "id.id", target = "id")
  @Mapping(source = "userId.id", target = "userId")
  public LoanDTO toDto(Loan prop);

  @Mapping(source = "id", target = "id.id")
  @Mapping(source = "userId", target = "userId.id")
  public Loan toDomain(LoanDTO loanDto);
}
