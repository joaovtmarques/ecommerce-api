package com.joaovtmarques.ecommerce.data.usecase.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joaovtmarques.ecommerce.domain.model.Category;
import com.joaovtmarques.ecommerce.domain.usecase.category.AddCategoryUseCase;
import com.joaovtmarques.ecommerce.infra.repository.CategoryRepository;

@Service
public class AddCategoryImpl implements AddCategoryUseCase {
  
  @Autowired
  private CategoryRepository categoryRepository;

  @Override
  public Category execute(String name) {
    Category category = new Category();
    category.setName(name);

    return categoryRepository.save(category);
  }

}
