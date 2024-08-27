package com.joaovtmarques.ecommerce.data.usecase.customer;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.joaovtmarques.ecommerce.data.dto.AddCustomerDTO;
import com.joaovtmarques.ecommerce.data.exception.CustomerAlreadyExistsException;
import com.joaovtmarques.ecommerce.domain.model.Customer;
import com.joaovtmarques.ecommerce.domain.usecase.customer.AddCustomerUseCase;
import com.joaovtmarques.ecommerce.infra.repository.CustomerRepository;

@Service
public class AddCustomerImpl implements AddCustomerUseCase {
  
  @Autowired
  private CustomerRepository customerRepository;

  @Transactional
  @Override
  public Customer execute(AddCustomerDTO customerDTO) {
    Customer customer = customerDTO.toModel();

    Optional<Customer> customerExists = customerRepository.findByEmail(customer.getEmail());

    if(customerExists.isPresent()) {
      throw new CustomerAlreadyExistsException();
    }

    return customerRepository.save(customer);
  }

}
