package com.joaovtmarques.ecommerce.data.usecase.category;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joaovtmarques.ecommerce.data.exception.AlreadyExistsException;
import com.joaovtmarques.ecommerce.domain.model.Category;
import com.joaovtmarques.ecommerce.domain.usecase.category.AddCategoryUseCase;
import com.joaovtmarques.ecommerce.infra.repository.CategoryRepository;

@Service
public class AddCategoryImpl implements AddCategoryUseCase {
  
  @Autowired
  private CategoryRepository categoryRepository;

  @Transactional
  @Override
  public Category execute(String name) {
    Optional<Category> categoryExists = categoryRepository.findByName(name);

    if(categoryExists.isPresent()) {
      throw new AlreadyExistsException("Uma categoria com esse nome já está cadastrada");
    }

    Category category = new Category();
    category.setName(name);

    return categoryRepository.save(category);
  }

}
