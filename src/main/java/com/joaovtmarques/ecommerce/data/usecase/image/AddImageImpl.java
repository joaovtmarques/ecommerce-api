package com.joaovtmarques.ecommerce.data.usecase.image;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.joaovtmarques.ecommerce.data.dto.UploadImageDTO;
import com.joaovtmarques.ecommerce.data.exception.BadRequestException;
import com.joaovtmarques.ecommerce.data.exception.NotFoundException;
import com.joaovtmarques.ecommerce.domain.model.Image;
import com.joaovtmarques.ecommerce.domain.model.Product;
import com.joaovtmarques.ecommerce.domain.usecase.image.AddImageUseCase;
import com.joaovtmarques.ecommerce.domain.usecase.upload.UploadImageUseCase;
import com.joaovtmarques.ecommerce.infra.repository.ImageRepository;
import com.joaovtmarques.ecommerce.infra.repository.ProductRepository;
import com.joaovtmarques.ecommerce.main.util.FileUploadUtil;

@Service
public class AddImageImpl implements AddImageUseCase{
  
  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private ImageRepository imageRepository;

  @Autowired
  private UploadImageUseCase uploadImage;

  @Transactional
  @Override
  public Image execute(Long productId, MultipartFile file) throws Exception {
    try {
      Optional<Product> productExists = productRepository.findById(productId);

      if(productExists.isEmpty()) {
        throw new NotFoundException("Produto {"+productId+"} não encontrado");
      }

      final String fileName = FileUploadUtil.getFileName(file.getOriginalFilename());
      FileUploadUtil.assertAllowed(file, FileUploadUtil.IMAGE_PATTERN);
      final UploadImageDTO uploadedImage = uploadImage.execute(file, fileName);
      final Image image = new Image();
      image.setImageUrl(uploadedImage.url());
      image.setProduct(productExists.get());
      
      return imageRepository.save(image);
    } catch (Exception e) {
      throw new BadRequestException(e.getMessage());
    }
  }

}
