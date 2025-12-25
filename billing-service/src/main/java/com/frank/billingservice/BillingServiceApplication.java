package com.frank.billingservice;

import com.frank.billingservice.entities.Bill;
import com.frank.billingservice.entities.ProductItem;
import com.frank.billingservice.feign.CustomerRestClient;
import com.frank.billingservice.feign.ProductRestClient;
import com.frank.billingservice.model.Customer;
import com.frank.billingservice.model.Product;
import com.frank.billingservice.repository.BillRepository;
import com.frank.billingservice.repository.ProductItemRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;

import java.util.Date;
import java.util.List;
import java.util.Random;


@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(BillingServiceApplication.class, args);
    }

    @Bean
    CommandLineRunner commandLineRunner(BillRepository billRepository,
                            ProductItemRepository productItemRepository,
                            CustomerRestClient customerRestClient,
                            ProductRestClient productRestClient) {
        return args -> {
            List<Customer> customers = customerRestClient.getAllCustomers();
            List<Product> products = productRestClient.getAllProducts();

            customers.forEach(customer -> {
                Bill bill = Bill.builder()
                        .billingDate(new Date())
                        .custumerId(customer.getId())
                        .build();
                billRepository.save(bill);

                products.forEach(product -> {
                    ProductItem productItem = ProductItem.builder()
                            .productId(product.getId())
                            .quantity(1+new Random().nextInt(10))
                            .unitPrice(product.getPrice())
                            .build();
                    productItemRepository.save(productItem);
                });
            });

        };
    }

}
