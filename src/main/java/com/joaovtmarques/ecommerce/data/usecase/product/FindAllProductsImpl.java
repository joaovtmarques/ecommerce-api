package com.joaovtmarques.ecommerce.data.usecase.product;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joaovtmarques.ecommerce.domain.model.Product;
import com.joaovtmarques.ecommerce.domain.usecase.product.FindAllProductsUseCase;
import com.joaovtmarques.ecommerce.infra.repository.ProductRepository;

@Service
public class FindAllProductsImpl implements FindAllProductsUseCase {
  
  @Autowired
  private ProductRepository productRepository;

  @Override
  public List<Product> execute() {
    return productRepository.findAll();
  }

}
