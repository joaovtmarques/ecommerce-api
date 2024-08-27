package com.joaovtmarques.ecommerce.data.usecase.product;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joaovtmarques.ecommerce.domain.model.Product;
import com.joaovtmarques.ecommerce.domain.usecase.product.FindProductByIdUseCase;
import com.joaovtmarques.ecommerce.infra.repository.ProductRepository;

@Service
public class FindProductByIdImpl implements FindProductByIdUseCase {
  
  @Autowired
  private ProductRepository productRepository;

  @Override
  public Optional<Product> execute(Long id) {
    return productRepository.findById(id);
  }
   
}
