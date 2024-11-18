package com.example.ecomm.product.service.api;

import com.example.ecomm.product.domain.model.Product;
import com.example.ecomm.product.service.db.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/v1/products")
public class ProductEndpointService {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> getAll() {
        return productService.getAll();
    }

    @PostMapping
    public void save(@RequestBody Product product) {
        productService.save(product);
    }

    @GetMapping("/{productId}")
    public Product getById(@PathVariable("productId") String productId) {
        return productService.findById(productId);
    }
}
