package com.joaovtmarques.ecommerce.presentation.controller.category;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaovtmarques.ecommerce.domain.model.Category;
import com.joaovtmarques.ecommerce.domain.usecase.category.FindAllCategoriesUseCase;

@RestController
@RequestMapping("/api/categories")
public class FindAllCategoriesController {
  
  @Autowired
  private FindAllCategoriesUseCase findAllCategories;

  @GetMapping
  public ResponseEntity<List<Category>> handle() {
    List<Category> categories = findAllCategories.execute();

    return ResponseEntity.status(200).body(categories);
  }

}
