package com.joaovtmarques.ecommerce.presentation.controller.image;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.joaovtmarques.ecommerce.data.exception.BadRequestException;
import com.joaovtmarques.ecommerce.domain.model.Image;
import com.joaovtmarques.ecommerce.domain.usecase.image.AddImageUseCase;

@RestController
@RequestMapping("/api/images")
public class AddImageController {
  
  @Autowired
  private AddImageUseCase addImage;

  @PostMapping
  public ResponseEntity<Image> handle(@RequestParam Long productId, @RequestParam MultipartFile file) {
    try {
      Image image = this.addImage.execute(productId, file);

      return ResponseEntity.status(201).body(image);
    } catch (Exception e) {
      throw new BadRequestException(e.getMessage());
    }
  }

}
