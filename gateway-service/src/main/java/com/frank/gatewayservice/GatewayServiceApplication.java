package com.frank.gatewayservice;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.discovery.ReactiveDiscoveryClient;
import org.springframework.cloud.gateway.discovery.DiscoveryClientRouteDefinitionLocator;
import org.springframework.cloud.gateway.discovery.DiscoveryLocatorProperties;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class GatewayServiceApplication {

    public static void main(String[] args) {
        SpringApplication.run(GatewayServiceApplication.class, args);
    }



    // Autre facon de configurer les routes dynamiques comme un bean dans une classe de configuration
    @Bean
    DiscoveryClientRouteDefinitionLocator dynamicRoutes(ReactiveDiscoveryClient rdc, DiscoveryLocatorProperties dlp) {
        return new DiscoveryClientRouteDefinitionLocator(rdc, dlp);
    }

}

//  Autre facon de configurer les routes statique comme un bean dans une classe de configuration
//@Bean
//    RouteLocator staticRoutes(RouteLocatorBuilder builder) {
//        return builder.routes()
//                .route("r1", predicate -> predicate.path("/customers/**").uri("lb://CUSTOMER-SERVICE"))
//                .route("r2", predicate -> predicate.path("/products/**").uri("lb://INVENTORY-SERVICE"))
//                .build();
//    }