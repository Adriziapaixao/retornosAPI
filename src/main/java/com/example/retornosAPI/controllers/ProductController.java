package com.example.retornosAPI.controllers;

import com.example.retornosAPI.dtos.ProductDTO;
import com.example.retornosAPI.models.ProductEntity;
import com.example.retornosAPI.services.ProductService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Collections;
import java.util.List;

@RestController
@RequestMapping("/api/products")
public class ProductController {

    @Autowired
    private final ProductService service;

    public ProductController(ProductService service) {
        this.service = service;
    }

    @PostMapping
    public ResponseEntity<ProductEntity> createProduct(@Valid @RequestBody ProductDTO productDTO) {
        ProductEntity createdProduct = service.createProduct(productDTO);
        return ResponseEntity.ok(createdProduct);
    }

    @GetMapping
    public ResponseEntity<List<ProductEntity>> getAllProducts() {
        return ResponseEntity.ok(service.getAllProducts());
    }

    @GetMapping("/{id}")
    public ResponseEntity<List<ProductEntity>> getProductById(@RequestBody ProductEntity productEntity, @PathVariable Long id) {
        return ResponseEntity.ok(Collections.singletonList(service.getProductById(id)));
    }

    @PutMapping("/{id}")
    public ResponseEntity<ProductEntity> updateProduct(@RequestBody ProductEntity productEntity, @PathVariable Long id) throws Throwable {
        return ResponseEntity.ok(service.updateProduct(id, productEntity));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteProduct(@PathVariable Long id) {
        service.deleteProduct(id);
        return ResponseEntity.noContent().build();
    }
}