package com.example.springcrud.steps;

import static org.junit.jupiter.api.Assertions.*;

import com.example.springcrud.model.Product;
import com.example.springcrud.service.ProductService;
import io.cucumber.java.en.*;
import org.springframework.beans.factory.annotation.Autowired;

public class ProductSteps {

  @Autowired
  private ProductService service;

  private Product createdProduct;

  @When("I create a product with name {string} and price {double}")
  public void iCreateAProduct(String name, double price) {
    createdProduct = service.create(new Product(name, price));
  }

  @Then("the product should be saved successfully")
  public void theProductShouldBeSavedSuccessfully() {
    assertNotNull(createdProduct);
    assertNotNull(createdProduct.getId());
  }

  @Given("a product with ID {long} exists")
  public void aProductWithIDExists(Long id) {
    Product p = new Product("Existing", 500);
    p.setId(id);
    service.create(p);
  }

  @When("I retrieve the product with ID {long}")
  public void iRetrieveProduct(Long id) {
    createdProduct = service.get(id).orElse(null);
  }

  @Then("I should receive a product with name {string}")
  public void iShouldReceiveAProduct(String name) {
    assertNotNull(createdProduct);
    assertEquals(name, createdProduct.getName());
  }
}
