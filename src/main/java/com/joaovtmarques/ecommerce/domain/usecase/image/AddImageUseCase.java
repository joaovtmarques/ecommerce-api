package com.joaovtmarques.ecommerce.domain.usecase.image;

import org.springframework.web.multipart.MultipartFile;

import com.joaovtmarques.ecommerce.domain.model.Image;

public interface AddImageUseCase {

  Image execute(Long productId, MultipartFile file) throws Exception;

}
