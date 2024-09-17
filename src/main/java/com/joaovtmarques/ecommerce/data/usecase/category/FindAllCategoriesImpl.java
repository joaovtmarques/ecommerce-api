package com.joaovtmarques.ecommerce.data.usecase.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joaovtmarques.ecommerce.data.exception.BadRequestException;
import com.joaovtmarques.ecommerce.domain.model.Category;
import com.joaovtmarques.ecommerce.domain.usecase.category.FindAllCategoriesUseCase;
import com.joaovtmarques.ecommerce.infra.repository.CategoryRepository;

@Service
public class FindAllCategoriesImpl implements FindAllCategoriesUseCase {
  
  @Autowired
  private CategoryRepository categoryRepository;

  @Override
  public List<Category> execute() {
    try {
      return categoryRepository.findAll();
    } catch (Exception e) {
      throw new BadRequestException(e.getMessage());
    }
  }

}
