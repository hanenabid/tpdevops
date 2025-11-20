package com.example.springcrud.service;

import com.example.springcrud.model.Product;
import com.example.springcrud.repository.ProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    private final ProductRepository repo;

    public ProductService(ProductRepository repo) {
        this.repo = repo;
    }

    public Product create(Product p) {
        return repo.save(p);
    }

    public List<Product> listAll() {
        return repo.findAll();
    }

    public Optional<Product> get(Long id) {
        return repo.findById(id);
    }

    public Product update(Long id, Product p) {
        return repo.findById(id).map(existing -> {
            existing.setName(p.getName());
            existing.setPrice(p.getPrice());
            return repo.save(existing);
        }).orElseThrow(() -> new RuntimeException("Product not found"));
    }

    public void delete(Long id) {
        repo.deleteById(id);
    }
}
