package com.joaovtmarques.ecommerce.data.usecase.category;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joaovtmarques.ecommerce.data.exception.BadRequestException;
import com.joaovtmarques.ecommerce.domain.model.Category;
import com.joaovtmarques.ecommerce.domain.usecase.category.FindCategoryByIdUseCase;
import com.joaovtmarques.ecommerce.infra.repository.CategoryRepository;

@Service
public class FindCategoryByIdImpl implements FindCategoryByIdUseCase {
  
  @Autowired
  private CategoryRepository categoryRepository;

  @Override
  public Optional<Category> execute(Long id) {
    try {
      return categoryRepository.findById(id);
    } catch (Exception e) {
      throw new BadRequestException(e.getMessage());
    }
  }

}
