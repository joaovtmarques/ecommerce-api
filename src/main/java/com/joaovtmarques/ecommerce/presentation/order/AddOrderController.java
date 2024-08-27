package com.joaovtmarques.ecommerce.presentation.order;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.joaovtmarques.ecommerce.data.dto.AddOrderDTO;
import com.joaovtmarques.ecommerce.domain.model.Order;
import com.joaovtmarques.ecommerce.domain.usecase.order.AddOrderUseCase;
import com.joaovtmarques.ecommerce.presentation.controller.protocols.ControllerProtocol;

@RestController
@RequestMapping("/api/orders")
public class AddOrderController implements ControllerProtocol<AddOrderDTO, ResponseEntity<Order>> {
  
  @Autowired
  private AddOrderUseCase addOrder;

  @Override
  @PostMapping
  public ResponseEntity<Order> handle(@RequestBody AddOrderDTO addOrderDTO) {
    Order order = addOrder.execute(addOrderDTO);

    return ResponseEntity.status(201).body(order);
  }

}
