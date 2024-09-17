package com.joaovtmarques.ecommerce.infra.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.joaovtmarques.ecommerce.domain.model.Image;

public interface ImageRepository extends JpaRepository<Image, Long> {}
