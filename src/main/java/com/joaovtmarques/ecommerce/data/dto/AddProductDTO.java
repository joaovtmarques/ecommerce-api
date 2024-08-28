package com.joaovtmarques.ecommerce.data.dto;

import org.hibernate.validator.constraints.URL;

import com.joaovtmarques.ecommerce.domain.model.Category;
import com.joaovtmarques.ecommerce.domain.model.Product;

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
  Long categoryId,
  @NotBlank(message = "A url da imagem do produto deve ser informada")
  @URL(message = "A url da imagem do produto deve ser válida")
  String imageUrl
) {
  
  public Product toModel(Category category) {
    Product product = new Product();
    product.setCategory(category);
    product.setImageUrl(imageUrl);
    product.setName(name);
    product.setPrice(price);

    return product;
  }

}
