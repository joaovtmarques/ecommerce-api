package com.joaovtmarques.ecommerce.presentation.controller.customer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaovtmarques.ecommerce.data.dto.AddCustomerDTO;
import com.joaovtmarques.ecommerce.domain.model.Customer;
import com.joaovtmarques.ecommerce.domain.usecase.customer.AddCustomerUseCase;
import com.joaovtmarques.ecommerce.presentation.controller.protocols.ControllerProtocol;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/customers")
public class AddCustomerController implements ControllerProtocol<AddCustomerDTO, ResponseEntity<Customer>> {
  
  @Autowired
  private AddCustomerUseCase addCustomer;

  @Override
  @PostMapping
  public ResponseEntity<Customer> handle(@Valid @RequestBody AddCustomerDTO addCustomerDTO) {
    return ResponseEntity.status(201).body(addCustomer.execute(addCustomerDTO));
  }

}
