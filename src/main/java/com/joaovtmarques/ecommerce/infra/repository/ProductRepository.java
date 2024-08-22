package com.joaovtmarques.ecommerce.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joaovtmarques.ecommerce.domain.model.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {}
