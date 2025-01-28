package com.example.retornosAPI.models;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.*;

@Entity
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

   @NotBlank(message = "Nome é obrigatório")
   @Size(min = 3, max = 100, message = "O nome deve ter entre 3 e 100 caracteres")
    private String name;

    @Size(max = 500, message = "A descrição pode ter no máximo 500 caracteres")
    private String description;

    @NotNull(message = "Preço é obrigatório")
    @DecimalMin(value = "0.01", message = "O preço deve ser maior que 0")
    private Double price;

    @NotNull(message = "Quantidade em estoque é obrigatória")
    @Min(value = 0, message = "A quantidade em estoque deve ser maior ou igual a 0")
    private int stockQuantity;

    @NotBlank(message = "Categoria é obrigatória")
    @Pattern(regexp = "Eletrônicos|Roupas|Alimentos", message = "Categoria inválida")
    private String category;

    public ProductEntity() {
    }

    public ProductEntity(Long id, String name, String description, Double price, int quantity, String category) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stockQuantity = quantity;
        this.category = category;
    }

    public ProductEntity(Object o, String name, Double price) {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    public int getQuantity() {
        return stockQuantity;
    }

    public void setQuantity(int quantity) {
        this.stockQuantity = quantity;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }
}