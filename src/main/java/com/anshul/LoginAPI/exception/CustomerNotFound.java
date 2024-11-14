package com.anshul.LoginAPI.exception;

import lombok.Data;
import lombok.EqualsAndHashCode;
@EqualsAndHashCode(callSuper = true)
@Data
public class CustomerNotFound extends RuntimeException {
  private final String msg;
}