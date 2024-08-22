package com.joaovtmarques.ecommerce.domain.usecase.customer;

import com.joaovtmarques.ecommerce.data.dto.AddCustomerDTO;
import com.joaovtmarques.ecommerce.domain.model.Customer;

public interface AddCustomerUseCase {
  
  Customer execute(AddCustomerDTO addCustomerDTO);

}
