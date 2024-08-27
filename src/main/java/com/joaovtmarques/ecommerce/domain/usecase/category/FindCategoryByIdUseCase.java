package com.joaovtmarques.ecommerce.domain.usecase.category;

import java.util.Optional;

import com.joaovtmarques.ecommerce.domain.model.Category;

public interface FindCategoryByIdUseCase {
  
  Optional<Category> execute(Long id);

}
