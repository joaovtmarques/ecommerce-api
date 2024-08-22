package com.joaovtmarques.ecommerce.data.usecase.customer;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joaovtmarques.ecommerce.domain.model.Customer;
import com.joaovtmarques.ecommerce.domain.usecase.customer.FindCustomerByIdUseCase;
import com.joaovtmarques.ecommerce.infra.repository.CustomerRepository;

@Service
public class FindCustomerByIdImpl implements FindCustomerByIdUseCase {
  
  @Autowired
  private CustomerRepository customerRepository;

  @Override
  public Optional<Customer> execute(Long id) {
    return customerRepository.findById(id);
  }

}
