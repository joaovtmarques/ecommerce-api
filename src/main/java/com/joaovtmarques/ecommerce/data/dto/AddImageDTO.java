package com.joaovtmarques.ecommerce.data.dto;

import org.springframework.web.multipart.MultipartFile;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

public record AddImageDTO(
  @NotNull(message = "Um produto válido deve ser informado")
  @NotEmpty(message = "Um produto válido deve ser informado")
  Long productId,
  @NotNull(message = "Uma imagem válida deve ser informada")
  @NotEmpty(message = "Uma imagem válida deve ser informada")
  MultipartFile file
) {}
