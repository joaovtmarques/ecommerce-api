package com.joaovtmarques.ecommerce.domain.usecase.category;

import java.util.List;

import com.joaovtmarques.ecommerce.domain.model.Category;

public interface FindAllCategoriesUseCase {
  
  List<Category> execute();

}
