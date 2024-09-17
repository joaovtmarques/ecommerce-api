package com.joaovtmarques.ecommerce.domain.usecase.upload;

import org.springframework.web.multipart.MultipartFile;

import com.joaovtmarques.ecommerce.data.dto.UploadImageDTO;

public interface UploadImageUseCase {
  
  UploadImageDTO execute(MultipartFile file, String fileName) throws Exception;

}
