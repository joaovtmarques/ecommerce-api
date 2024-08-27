package com.joaovtmarques.ecommerce.infra.handler;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

import com.joaovtmarques.ecommerce.data.exception.BadRequestException;
import com.joaovtmarques.ecommerce.data.exception.CustomerAlreadyExistsException;
import com.joaovtmarques.ecommerce.data.exception.NotFoundException;

@ControllerAdvice
public class ExceptionHandler extends ResponseEntityExceptionHandler {

  @org.springframework.web.bind.annotation.ExceptionHandler(CustomerAlreadyExistsException.class)
  private ResponseEntity<String> userAlreadyExists(CustomerAlreadyExistsException exception) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
  }

  @org.springframework.web.bind.annotation.ExceptionHandler(BadRequestException.class)
  private ResponseEntity<String> badRequest(BadRequestException exception) {
    return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(exception.getMessage());
  }

  @org.springframework.web.bind.annotation.ExceptionHandler(NotFoundException.class)
  private ResponseEntity<String> notFound(NotFoundException exception) {
    return ResponseEntity.status(HttpStatus.NOT_FOUND).body(exception.getMessage());
  }

}