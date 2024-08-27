package com.joaovtmarques.ecommerce.domain.usecase.order;

import com.joaovtmarques.ecommerce.data.dto.AddOrderDTO;
import com.joaovtmarques.ecommerce.domain.model.Order;

public interface AddOrderUseCase {
  
  Order execute(AddOrderDTO addOrderDTO);
  
}
