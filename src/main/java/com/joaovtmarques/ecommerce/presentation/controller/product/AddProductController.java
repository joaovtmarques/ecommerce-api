package com.joaovtmarques.ecommerce.presentation.controller.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaovtmarques.ecommerce.data.dto.AddProductDTO;
import com.joaovtmarques.ecommerce.domain.model.Product;
import com.joaovtmarques.ecommerce.domain.usecase.product.AddProductUseCase;
import com.joaovtmarques.ecommerce.presentation.controller.protocols.ControllerProtocol;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/api/products")
public class AddProductController implements ControllerProtocol<AddProductDTO, ResponseEntity<Product>> {
  
  @Autowired
  private AddProductUseCase addProduct;

  @Override
  @PostMapping
  public ResponseEntity<Product> handle(@Valid @RequestBody AddProductDTO addProductDTO) {
    Product product = addProduct.execute(addProductDTO);

    return ResponseEntity.status(201).body(product);

  }

}
