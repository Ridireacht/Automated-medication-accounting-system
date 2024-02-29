package com.vasiliy.project.exception;

import java.util.List;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
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

  @ExceptionHandler(MethodArgumentNotValidException.class)
  public ResponseEntity<String> handleValidationException(MethodArgumentNotValidException ex) {
    BindingResult bindingResult = ex.getBindingResult();
    List<FieldError> fieldErrors = bindingResult.getFieldErrors();

    StringBuilder errorMessage = new StringBuilder();
    errorMessage.append("ошибка валидации, ");
    for (FieldError fieldError : fieldErrors) {
      errorMessage.append(fieldError.getField()).append(" ");
      errorMessage.append(fieldError.getDefaultMessage()).append("; ");
    }

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{ \"message\": \"" + errorMessage + "\" }");
  }
}
