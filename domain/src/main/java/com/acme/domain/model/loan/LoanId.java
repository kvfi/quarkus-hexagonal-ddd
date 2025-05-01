package com.acme.domain.model.loan;

import com.acme.domain.shared.ValueObject;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class LoanId implements ValueObject<LoanId> {
  private static final long serialVersionUID = 6670795510755279510L;
  private String id;

  @Override
  public boolean sameValueAs(LoanId other) {
    return other != null && this.id.equals(other.id);
  }
}
