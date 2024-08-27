package com.joaovtmarques.ecommerce.presentation.controller.category;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaovtmarques.ecommerce.domain.model.Category;
import com.joaovtmarques.ecommerce.domain.usecase.category.FindCategoryByIdUseCase;
import com.joaovtmarques.ecommerce.presentation.controller.protocols.ControllerProtocol;

@RestController
@RequestMapping("/api/categories")
public class FindCategoryByIdController implements ControllerProtocol<Long, ResponseEntity<Category>> {
  
  @Autowired
  private FindCategoryByIdUseCase findCategoryById;

  @Override
  @GetMapping("/{id}")
  public ResponseEntity<Category> handle(@PathVariable Long id) {
    Optional<Category> category = findCategoryById.execute(id);

    if(category.isEmpty()) {
      throw new Error("Categoria não encontrada");
    }

    return ResponseEntity.status(200).body(category.get());
  }

}
