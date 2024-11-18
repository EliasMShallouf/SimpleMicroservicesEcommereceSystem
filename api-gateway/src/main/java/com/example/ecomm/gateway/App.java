package com.example.ecomm.gateway;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration;
import org.springframework.cloud.client.discovery.EnableDiscoveryClient;
import org.springframework.cloud.gateway.route.RouteLocator;
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
@EnableDiscoveryClient
public class App {
	public static void main(String[] args) {
		SpringApplication.run(App.class, args);
	}

	@Bean
	public RouteLocator routeLocator(RouteLocatorBuilder builder) {
		return builder.routes()
			.route("user-service", r -> r.path("/api/v1/users/**").uri("lb://user-service"))
			.route("product-service", r -> r.path("/api/v1/products/**", "/api/v1/categories/**").uri("lb://product-service"))
			.route("order-service", r -> r.path("/api/v1/orders/**").uri("lb://order-service"))
			.build();
	}
}
