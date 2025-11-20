package com.example.springcrud.service;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

import com.example.springcrud.model.Product;
import com.example.springcrud.repository.ProductRepository;
import java.util.List;
import java.util.Optional;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

class ProductServiceTest {

  @Mock
  private ProductRepository repo;

  @InjectMocks
  private ProductService service;

  public ProductServiceTest() {
    MockitoAnnotations.openMocks(this);
  }

  @Test
  void testCreateProduct() {
    Product p = new Product("Phone", 800);
    when(repo.save(p)).thenReturn(p);

    Product saved = service.create(p);

    assertEquals("Phone", saved.getName());
  }

  @Test
  void testGetProduct() {
    Product p = new Product("PC", 1200);
    p.setId(1L);

    when(repo.findById(1L)).thenReturn(Optional.of(p));

    Optional<Product> result = service.get(1L);

    assertTrue(result.isPresent());
    assertEquals("PC", result.get().getName());
  }

  @Test
  void testListAllProducts() {
    when(repo.findAll()).thenReturn(List.of(new Product("A", 10)));

    List<Product> products = service.listAll();

    assertEquals(1, products.size());
  }
}
