package com.joaovtmarques.ecommerce.data.usecase.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

import com.joaovtmarques.ecommerce.data.dto.AddProductDTO;
import com.joaovtmarques.ecommerce.data.exception.BadRequestException;
import com.joaovtmarques.ecommerce.data.exception.NotFoundException;
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

  @Transactional
  @Override
  public Product execute(AddProductDTO addProductDTO) {
    try {
      Optional<Category> categoryExists = categoryRepository.findById(addProductDTO.categoryId());

      if(categoryExists.isEmpty()) {
        throw new NotFoundException("Categoria não encontrada");
      }

      Product product = addProductDTO.toModel(categoryExists.get());

      return productRepository.save(product);
    } catch (Exception e) {
      throw new BadRequestException(e.getMessage());
    }
  }

}