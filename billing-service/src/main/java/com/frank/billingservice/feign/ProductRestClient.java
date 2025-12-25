package com.frank.billingservice.feign;

import com.frank.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "inventory-service")
public interface ProductRestClient {

    @GetMapping("/products/{id}")
    public Product getProductById(@PathVariable String id);

    @GetMapping("/products")
    public List<Product> getAllProducts();

}
