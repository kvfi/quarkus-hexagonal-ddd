package com.acme.domain.model.user;

import com.acme.domain.shared.ValueObject;
import lombok.Builder;
import lombok.Getter;

@Builder
@Getter
public class UserId implements ValueObject<UserId> {
  private static final long serialVersionUID = -8138310647368230992L;
  private String id;

  @Override
  public boolean sameValueAs(UserId other) {
    return other != null && this.id.equals(other.id);
  }
}
