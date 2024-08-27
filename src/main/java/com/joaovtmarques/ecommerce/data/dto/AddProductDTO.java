package com.joaovtmarques.ecommerce.data.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AddProductDTO(
  @NotBlank(message = "O nome do produto deve ser informado")
  String name,
  @NotNull(message = "O preço do produto deve ser informado")
  Double price,
  @Min(value = 0L, message = "Uma categoria válida de produto deve ser informada")
  @NotNull(message = "A categoria do produto deve ser informada")
  Long categoryId
) {
  
}
