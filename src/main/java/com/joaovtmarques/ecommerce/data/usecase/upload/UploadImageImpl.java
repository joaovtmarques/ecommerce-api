package com.joaovtmarques.ecommerce.data.usecase.upload;

import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.cloudinary.Cloudinary;
import com.joaovtmarques.ecommerce.data.dto.UploadImageDTO;
import com.joaovtmarques.ecommerce.data.exception.BadRequestException;
import com.joaovtmarques.ecommerce.domain.usecase.upload.UploadImageUseCase;

@Service
public class UploadImageImpl implements UploadImageUseCase {
  
  @Autowired
  private final Cloudinary cloudinary;

  public UploadImageImpl(Cloudinary cloudinary) {
    this.cloudinary = cloudinary;
  }

  @Transactional
  @Override
  public UploadImageDTO execute(MultipartFile file, String fileName) throws Exception {
    try {
      @SuppressWarnings("rawtypes")
      final Map result = cloudinary.uploader().upload(file.getBytes(), Map.of("public_id", "ecommerce/products/" + fileName));
      final String url = (String) result.get("secure_url");
      final String publicId = (String) result.get("public_id");

      return new UploadImageDTO(url, publicId);
    } catch (Exception e) {
      throw new BadRequestException(e.getMessage());
    }
  }

}
