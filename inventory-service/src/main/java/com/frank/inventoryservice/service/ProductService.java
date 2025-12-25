package com.frank.inventoryservice.service;

import com.frank.inventoryservice.entities.Product;
import com.frank.inventoryservice.repository.ProductRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@AllArgsConstructor
public class ProductService {
   final private ProductRepository productRepository;

   public List<Product> getAllProducts() {
       return productRepository.findAll();
   }

    public Product getproductById(Long id) {
       return productRepository.findById(id).get();
    }
}
