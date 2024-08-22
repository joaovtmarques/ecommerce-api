package com.joaovtmarques.ecommerce.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joaovtmarques.ecommerce.domain.model.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {}
