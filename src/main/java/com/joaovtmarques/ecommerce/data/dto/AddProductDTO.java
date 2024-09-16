package com.joaovtmarques.ecommerce.data.dto;

import java.util.List;

import com.joaovtmarques.ecommerce.domain.model.Category;
import com.joaovtmarques.ecommerce.domain.model.Image;
import com.joaovtmarques.ecommerce.domain.model.Product;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record AddProductDTO(
  @NotBlank(message = "O nome do produto deve ser informado")
  String name,
  @NotBlank(message = "A descrição do produto deve ser informada")
  String description,
  @NotNull(message = "O preço do produto deve ser informado")
  Double price,
  @Min(value = 0L, message = "Uma categoria válida de produto deve ser informada")
  @NotNull(message = "A categoria do produto deve ser informada")
  Long categoryId,
  @NotBlank(message = "A url da imagem do produto deve ser informada")
  List<Image> images
) {
  
  public Product toModel(Category category) {
    Product product = new Product();
    product.setCategory(category);
    product.setImages(images);
    product.setName(name);
    product.setDescription(description);
    product.setPrice(price);

    return product;
  }

}
