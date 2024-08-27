package com.joaovtmarques.ecommerce.data.usecase.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.joaovtmarques.ecommerce.data.dto.AddOrderDTO;
import com.joaovtmarques.ecommerce.data.exception.NotFoundException;
import com.joaovtmarques.ecommerce.domain.model.Customer;
import com.joaovtmarques.ecommerce.domain.model.Order;
import com.joaovtmarques.ecommerce.domain.model.Product;
import com.joaovtmarques.ecommerce.domain.usecase.order.AddOrderUseCase;
import com.joaovtmarques.ecommerce.infra.repository.CustomerRepository;
import com.joaovtmarques.ecommerce.infra.repository.OrderRepository;
import com.joaovtmarques.ecommerce.infra.repository.ProductRepository;

import java.util.List;
import java.util.Optional;
import java.util.ArrayList;

@Service
public class AddOrderImpl implements AddOrderUseCase {
  
  @Autowired
  private ProductRepository productRepository;

  @Autowired
  private CustomerRepository customerRepository;

  @Autowired
  private OrderRepository orderRepository;

  @Override
  public Order execute(AddOrderDTO addOrderDTO) {
    List<Product> products = new ArrayList<Product>();
    Double totalPrice = 0D;

    for(Long productId:addOrderDTO.productsId()) {
      Optional<Product> productExists = productRepository.findById(productId);

      if(productExists.isEmpty()) {
        throw new NotFoundException("Produto {"+productId+"} não encontrado");
      }

      products.add(productExists.get());
      totalPrice += productExists.get().getPrice();
    }

    Optional<Customer> customerExists = customerRepository.findById(addOrderDTO.customerId());

    if(customerExists.isEmpty()) {
      throw new NotFoundException("Cliente {"+addOrderDTO.customerId()+"} não encontrado");
    }

    Order order = new Order();
    order.setCustomer(customerExists.get());
    order.setProducts(products);
    order.setTotalPrice(totalPrice);

    return orderRepository.save(order);
  }

}
