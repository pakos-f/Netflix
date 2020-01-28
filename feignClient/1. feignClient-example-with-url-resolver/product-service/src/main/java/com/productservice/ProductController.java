package com.productservice;

import org.apache.log4j.Logger;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;


@RestController
public class ProductController {
	
    private static List<Product> productList = new ArrayList<>();
    private static final Logger LOG = Logger.getLogger(ProductController.class.getName());
    
    static {
        productList.add(new Product(1, "product-1", 12.0));
        productList.add(new Product(2, "product-2", 34.0));
        productList.add(new Product(3, "product-3", 9.0));
    }

    @GetMapping("/products")
    public ResponseEntity<?> getProsucts() {
        return ResponseEntity.ok(productList);
    }

    @GetMapping("/product/{id}")
    public ResponseEntity<?> getProsucts(@PathVariable int id) {

        Product product = findProduct(id);
        if (product == null) {
            return ResponseEntity.badRequest().body("Invalid product Id");
        }
        return ResponseEntity.ok(product);
    }

    private Product findProduct(int id) {
        return productList.stream()
                .filter(user -> user.getId().equals(id))
                .findFirst()
                .orElse(null);
    }
}
