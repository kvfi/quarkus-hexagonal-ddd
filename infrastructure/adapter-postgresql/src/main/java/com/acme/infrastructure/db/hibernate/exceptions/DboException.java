package com.acme.infrastructure.db.hibernate.exceptions;

public class DboException extends RuntimeException {
  private static final long serialVersionUID = -1204614246254878673L;

  public DboException(String message) {
    super(message);
  }

  public DboException(String format, Object... objects) {
    super(String.format(format, objects));
  }
}
