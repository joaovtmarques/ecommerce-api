package com.joaovtmarques.ecommerce.presentation.controller.customer;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaovtmarques.ecommerce.domain.model.Customer;
import com.joaovtmarques.ecommerce.domain.usecase.customer.FindCustomerByIdUseCase;
import com.joaovtmarques.ecommerce.presentation.controller.protocols.ControllerProtocol;

@RestController
@RequestMapping("/api/customers")
public class FindCustomerByIdController implements ControllerProtocol<Long, ResponseEntity<Customer>>{
  
  @Autowired
  private FindCustomerByIdUseCase findCustomerById;

  @Override
  @GetMapping("/{id}")
  public ResponseEntity<Customer> handle(@PathVariable Long id) {
    Optional<Customer> customer = findCustomerById.execute(id);

    if(customer.isEmpty()) {
      throw new Error("Usuário não encontrado");
    }

    return ResponseEntity.status(200).body(customer.get());
  }

}
