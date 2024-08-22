package com.joaovtmarques.ecommerce.domain.usecase.customer;

import java.util.Optional;

import com.joaovtmarques.ecommerce.domain.model.Customer;

public interface FindCustomerByIdUseCase {
  
  Optional<Customer> execute(Long id);

}
