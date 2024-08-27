package com.joaovtmarques.ecommerce.presentation.controller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaovtmarques.ecommerce.domain.model.Product;
import com.joaovtmarques.ecommerce.domain.usecase.product.FindAllProductsUseCase;

import java.util.List;

@RestController
@RequestMapping("/api/products")
public class FindAllProductsController {
  
  @Autowired
  private FindAllProductsUseCase findAllProducts;

  @GetMapping
  ResponseEntity<List<Product>> handle() {
    List<Product> products = findAllProducts.execute();

    return ResponseEntity.status(200).body(products);
  }

}
