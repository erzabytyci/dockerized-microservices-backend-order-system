package com.example.product_service.service;

import com.example.product_service.model.Product;
import com.example.product_service.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
public class ProductService {

    @Autowired
    private ProductRepository productRepository;

    @Transactional
    public Product createProduct(Product product) {
        System.out.println("Saving Product: " + product); // Add log
        return productRepository.save(product); // Add log here as well
    }

    public void deleteProduct(Long id) {
        productRepository.deleteById(id);  // Deletes the product by id
    }
}
