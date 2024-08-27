package com.joaovtmarques.ecommerce.data.dto;

import org.hibernate.validator.constraints.br.CPF;

import com.joaovtmarques.ecommerce.domain.model.Customer;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public record AddCustomerDTO(
  @NotBlank(message = "O nome completo deve ser informado")
  String name,
  @NotBlank(message = "O e-mail deve ser informado")
  @Email(message = "Um e-mail válido deve ser informado")
  String email,
  @NotBlank(message = "Uma senha deve ser informada")
  @Size(min=8, max=30, message="A senha deve ter no mínimo 8 caracteres e no máximo 30")
  String password,
  @NotBlank(message = "Um CPF válido deve ser informado")
  @CPF(message = "Um CPF válido deve ser informado")
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
