package com.joaovtmarques.ecommerce.domain.usecase.product;

import com.joaovtmarques.ecommerce.data.dto.AddProductDTO;
import com.joaovtmarques.ecommerce.domain.model.Product;

public interface AddProductUseCase {
  
  Product execute(AddProductDTO addProductDTO);

}

