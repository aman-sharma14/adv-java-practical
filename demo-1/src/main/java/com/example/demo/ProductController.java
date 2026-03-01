package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController	
public class ProductController {
	@Autowired
    private ProductService service;

    // Save a product to the DB
    @PostMapping("/product")
    public Product addProduct(@RequestBody Product product) {
        return service.createProduct(product);
    }

    // Get all products from the DB
    @GetMapping("/products")
    public List<Product> getProducts() {
        return service.getAllProducts();
    }
    
    @GetMapping("/product/{id}")
    public Product getProductById(@PathVariable int id){
    	return service.getProductById(id);
    }
    
    @DeleteMapping("/delProducts/{id}")
    public void deleteProductById(@PathVariable int id) {
    	service.deleteProduct(id);
    }
    
    @PutMapping("/updateProduct")
    public Product updateProduct(@RequestBody Product p) {
    	return service.updateProduct(p);
    }
	
}
