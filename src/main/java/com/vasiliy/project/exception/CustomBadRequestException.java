package com.vasiliy.project.exception;

public class CustomBadRequestException extends RuntimeException {

  public CustomBadRequestException() {
    super("ошибка отправки запроса");
  }
}
