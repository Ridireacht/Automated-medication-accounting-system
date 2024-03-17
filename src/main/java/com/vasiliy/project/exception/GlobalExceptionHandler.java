package com.vasiliy.project.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import java.util.List;

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

    StringBuilder errorBuilder = new StringBuilder();
    errorBuilder.append("ошибка валидации, ");
    for (FieldError fieldError : fieldErrors) {
      errorBuilder.append(fieldError.getField()).append(" ");

      if (fieldError.getCode().equals("Pattern")) {
        errorBuilder.append("не соответствует регулярному выражению").append("; ");
      } else {
        errorBuilder.append(fieldError.getDefaultMessage()).append("; ");
      }
    }

    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("{ \"message\": \"" + errorBuilder + "\" }");
  }
}
