package com.example.demo;

import java.util.List;

public interface ProductService {
	Product createProduct(Product product);
    Product getProductById(Integer id);
    List<Product> getAllProducts();
    Product saveProduct(Product product); 
    void deleteProduct(Integer id);
	Product updateProduct(Product p);
    
    
}
