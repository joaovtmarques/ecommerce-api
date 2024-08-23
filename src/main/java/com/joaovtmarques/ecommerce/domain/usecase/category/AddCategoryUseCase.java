package com.joaovtmarques.ecommerce.domain.usecase.category;

import com.joaovtmarques.ecommerce.domain.model.Category;

public interface AddCategoryUseCase {
  
  Category execute(String name);

}
