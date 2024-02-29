package com.vasiliy.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class GlobalExceptionHandler {

  @ExceptionHandler(CustomValidationException.class)
  public ResponseEntity<String> handleCustomValidationException(CustomValidationException ex) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{ \"message\": \"" + ex.getMessage() + "\" }");
  }

  @ExceptionHandler(CustomBadRequestException.class)
  public ResponseEntity<String> handleCustomBadRequestException(CustomBadRequestException ex) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{ \"message\": \"" + ex.getMessage() + "\" }");
  }
}
