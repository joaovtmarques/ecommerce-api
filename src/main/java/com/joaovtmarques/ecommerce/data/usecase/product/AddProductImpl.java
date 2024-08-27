package com.joaovtmarques.ecommerce.data.usecase.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

import com.joaovtmarques.ecommerce.data.dto.AddProductDTO;
import com.joaovtmarques.ecommerce.domain.model.Category;
import com.joaovtmarques.ecommerce.domain.model.Product;
import com.joaovtmarques.ecommerce.domain.usecase.product.AddProductUseCase;
import com.joaovtmarques.ecommerce.infra.repository.CategoryRepository;
import com.joaovtmarques.ecommerce.infra.repository.ProductRepository;

@Service
public class AddProductImpl implements AddProductUseCase {

  @Autowired
  private ProductRepository productRepository;

  @Autowired 
  private CategoryRepository categoryRepository;

  @Override
  public Product execute(AddProductDTO addProductDTO) {
    Optional<Category> categoryExists = categoryRepository.findById(addProductDTO.categoryId());

    if(categoryExists.isEmpty()) {
      throw new Error("Categoria não encontrada");
    }

    Product product = new Product();
    product.setName(addProductDTO.name());
    product.setPrice(addProductDTO.price());
    product.setCategory(categoryExists.get());

    return productRepository.save(product);
  }

}