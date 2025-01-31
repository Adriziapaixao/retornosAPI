package com.example.retornosAPI.utils;

import com.example.retornosAPI.models.ProductEntity;

import java.util.regex.Pattern;

public class ProductUtil {

    // Valida se o nome do produto é válido
    public static boolean isValidName(String name) {
        if (name == null || name.isBlank()) {
            return false;
        }
        return name.length() >= 3 && name.length() <= 100;
    }

    // Valida se a descrição do produto é válida
    public static boolean isValidDescription(String description) {
        if (description == null) {
            return true; // Descrição é opcional
        }
        return description.length() <= 500;
    }

    // Valida se o preço do produto é válido
    public static boolean isValidPrice(Double price) {
        return price != null && price >= 0.01;
    }

    // Valida se a quantidade em estoque é válida
    public static boolean isValidStockQuantity(Integer stockQuantity) {
        return stockQuantity != null && stockQuantity >= 0;
    }

    // Valida se a categoria do produto é válida
    public static boolean isValidCategory(String category) {
        if (category == null || category.isBlank()) {
            return false;
        }
        // Regex para validar as categorias permitidas
        String validCategories = "Eletrônicos|Roupas|Alimentos";
        return Pattern.matches(validCategories, category);
    }

    // Método para validar um objeto ProductEntity completo
    public static boolean isValidProduct(ProductEntity product) {
        return isValidName(product.getName()) &&
                isValidDescription(product.getDescription()) &&
                isValidPrice(product.getPrice()) &&
                isValidStockQuantity(product.getStockQuantity()) &&
                isValidCategory(product.getCategory());
    }

}

