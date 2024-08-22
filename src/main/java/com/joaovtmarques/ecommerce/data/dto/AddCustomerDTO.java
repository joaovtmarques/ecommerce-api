package com.joaovtmarques.ecommerce.data.dto;

import com.joaovtmarques.ecommerce.domain.model.Customer;

public record AddCustomerDTO(
      String name,
      String email,
      String password,
      String cpf
) {

  public Customer toModel() {
    Customer customer = new Customer();
    customer.setName(name());
    customer.setEmail(email());
    customer.setPassword(password());
    customer.setCpf(cpf());

    return customer;
  }

}
