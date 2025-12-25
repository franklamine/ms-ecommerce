package com.frank.inventoryservice.controller;

import com.frank.inventoryservice.entities.Product;
import com.frank.inventoryservice.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@AllArgsConstructor
@RestController
@RequestMapping(path = "products")
public class ProductController {
    private final ProductService productService;

    @GetMapping
    public List<Product> getAllProducts() {
        return productService.getAllProducts();
    }

    @GetMapping(path = "{id}")
    public Product getProduct(@PathVariable Long id) {
        return productService.getproductById(id);
    }
}
