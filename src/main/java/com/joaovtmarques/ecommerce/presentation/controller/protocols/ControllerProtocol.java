package com.joaovtmarques.ecommerce.presentation.controller.protocols;

public interface ControllerProtocol<T, R> {
  
  R handle(T t);
  
}
