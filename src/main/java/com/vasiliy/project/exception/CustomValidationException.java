package com.vasiliy.project.exception;

public class CustomValidationException extends RuntimeException {

  public CustomValidationException(String reason) {
    super("ошибка валидации, " + reason);
  }
}
