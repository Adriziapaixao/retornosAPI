package com.example.retornosAPI.repositories;

import com.example.retornosAPI.models.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<ProductEntity, Long> {
    // Metodo para buscar produtos pelo nome (case insensitive)
    List<ProductEntity> findByNameContainingIgnoreCase(String name);

    boolean existsByName(String name);

    Optional<Object> findByName(String name);
}