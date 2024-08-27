package com.joaovtmarques.ecommerce.domain.usecase.product;

import java.util.Optional;

import com.joaovtmarques.ecommerce.domain.model.Product;

public interface FindProductByIdUseCase {
  
  Optional<Product> execute(Long id);

}
