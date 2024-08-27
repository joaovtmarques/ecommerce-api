package com.joaovtmarques.ecommerce.data.dto;

import java.util.List;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record AddOrderDTO(
  @NotNull(message = "Os produtos do pedido devem ser informados")
  @NotEmpty(message = "Os produtos do pedido devem ser informados")
  List<Long> productsId,
  @NotNull(message = "Informe um ID de cliente válido")
  @Min(value = 0L, message = "Informe um ID de cliente válido")
  Long customerId) {

}
