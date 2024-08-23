package com.joaovtmarques.ecommerce.presentation.controller.category;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.joaovtmarques.ecommerce.domain.model.Category;
import com.joaovtmarques.ecommerce.domain.usecase.category.AddCategoryUseCase;
import com.joaovtmarques.ecommerce.presentation.controller.protocols.ControllerProtocol;

@RestController
@RequestMapping("/api/categories")
public class AddCategoryController implements ControllerProtocol<String, ResponseEntity<Category>> {
  
  @Autowired
  private AddCategoryUseCase addCategory;

  @Override
  @PostMapping
  public ResponseEntity<Category> handle(@RequestParam String name) {
    Category category = addCategory.execute(name.toString());

    return ResponseEntity.status(201).body(category);
  }

}
