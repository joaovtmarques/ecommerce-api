package com.joaovtmarques.ecommerce.infra.repository;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joaovtmarques.ecommerce.domain.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Long> {

  Optional<Category> findByName(String name);

}
