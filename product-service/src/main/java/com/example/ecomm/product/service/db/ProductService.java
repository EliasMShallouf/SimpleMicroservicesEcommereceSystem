package com.example.ecomm.product.service.db;

import com.example.ecomm.product.domain.model.Product;
import com.example.ecomm.product.domain.model.repository.ProductRepository;
import com.example.ecomm.product.service.utils.ListHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public void save(Product product) {
        productRepository.save(product);
    }

    public Product findById(String id) {
        return productRepository.findById(id).orElseThrow();
    }

    public List<Product> getAll() {
        return ListHelper.toList(productRepository.findAll());
    }
}
