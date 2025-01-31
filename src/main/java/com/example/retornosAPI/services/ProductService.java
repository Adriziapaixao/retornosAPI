package com.example.retornosAPI.services;

import com.example.retornosAPI.dtos.ProductDTO;
import com.example.retornosAPI.models.ProductEntity;
import com.example.retornosAPI.repositories.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService {

    @Autowired
    private final ProductRepository repository;

    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public ProductEntity createProduct(ProductDTO productDTO) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setName(productDTO.getName());
        productEntity.setDescription(productDTO.getDescription());
        productEntity.setPrice(productDTO.getPrice());
        productEntity.setStockQuantity(productDTO.getStockQuantity());
        productEntity.setCategory(productDTO.getCategory());

        // Salvando a entidade no repositório
        return repository.save(productEntity);
    }

    public ProductEntity getProductById(Long id) {
        return repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com o ID: " + id));
    }

    public List<ProductEntity> getAllProducts() {
        return repository.findAll();
    }

    public ProductEntity updateProduct(Long id, ProductEntity updatedProductDTO) {
        if (id == null) {
            throw new IllegalArgumentException("O ID do produto não pode ser nulo.");
        }
        ProductEntity existingEntity = repository.findById(id)
                .orElseThrow(() -> new RuntimeException("Produto não encontrado com o ID: " + id));

        existingEntity.setName(updatedProductDTO.getName());
        existingEntity.setDescription(updatedProductDTO.getDescription());
        existingEntity.setPrice(updatedProductDTO.getPrice());
        existingEntity.setStockQuantity(updatedProductDTO.getStockQuantity());
        existingEntity.setCategory(updatedProductDTO.getCategory());

        // Salvar as alterações no banco de dados
        return (ProductEntity) repository.save(existingEntity);
    }

    public void deleteProduct(Long id) {
        if (!repository.existsById(id)) {
            throw new RuntimeException("Produto não encontrado com o ID: " + id);
        }
        repository.deleteById(id);
    }

}