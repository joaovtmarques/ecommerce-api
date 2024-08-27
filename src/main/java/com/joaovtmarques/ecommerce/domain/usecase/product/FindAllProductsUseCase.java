package com.joaovtmarques.ecommerce.domain.usecase.product;

import java.util.List;

import com.joaovtmarques.ecommerce.domain.model.Product;

public interface FindAllProductsUseCase {
  
  List<Product> execute();

}
