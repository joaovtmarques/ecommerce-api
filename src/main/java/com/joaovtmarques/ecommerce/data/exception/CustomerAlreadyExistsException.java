package com.joaovtmarques.ecommerce.data.exception;

public class CustomerAlreadyExistsException extends RuntimeException {
  
  public CustomerAlreadyExistsException() {
    super("Um cliente com estes dados já está cadastrado");
  }

  public CustomerAlreadyExistsException(String message) {
    super(message);
  }

}
