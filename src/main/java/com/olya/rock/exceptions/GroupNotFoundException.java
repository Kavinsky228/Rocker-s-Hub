package com.olya.rock.exceptions;

public class GroupNotFoundException extends RuntimeException {
  public GroupNotFoundException(String message) {
    super(message);
  }
}