package com.frank.inventoryservice;

import com.frank.inventoryservice.entities.Product;
import com.frank.inventoryservice.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(InventoryServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner start(ProductRepository productRepository) {
        return args -> {
            productRepository.save(Product.builder()
                    .name("Computer").price(200).quantity(12).build());
            productRepository.save(Product.builder()
                    .name("Printer").price(300).quantity(30).build());
            productRepository.save(Product.builder()
                    .name("Router").price(500).quantity(16).build());
            productRepository.save(Product.builder()
                    .name("Mousse").price(750).quantity(50).build());
        };
    }

}
