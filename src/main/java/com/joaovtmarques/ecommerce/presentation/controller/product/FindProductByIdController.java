package com.joaovtmarques.ecommerce.presentation.controller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaovtmarques.ecommerce.domain.model.Product;
import com.joaovtmarques.ecommerce.domain.usecase.product.FindProductByIdUseCase;
import com.joaovtmarques.ecommerce.presentation.controller.protocols.ControllerProtocol;

import java.util.Optional;

@RestController
@RequestMapping("/api/products")
public class FindProductByIdController implements ControllerProtocol<Long, ResponseEntity<Product>> {
  
  @Autowired
  private FindProductByIdUseCase findProductById;

  @Override
  @PostMapping("/{id}")
  public ResponseEntity<Product> handle(@PathVariable Long id) {
    Optional<Product> productExists = findProductById.execute(id);

    if(productExists.isEmpty()) {
      throw new Error("Produto não encontrado");
    }

    return ResponseEntity.status(200).body(productExists.get());
  }

}
