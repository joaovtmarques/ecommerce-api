package com.joaovtmarques.ecommerce.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joaovtmarques.ecommerce.domain.model.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {}
