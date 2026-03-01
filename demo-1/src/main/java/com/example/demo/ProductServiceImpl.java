package com.example.demo;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
    private ProductRepository productRepository;

    @Override
    public Product createProduct(Product product) {
        return productRepository.save(product);
    }

    @Override
    public Product getProductById(Integer id) {
        return productRepository.findById(id).orElse(null);
    }

    @Override
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }

    @Override
    public Product saveProduct(Product product) {
        return productRepository.save(product);
    }

	@Override
	public void deleteProduct(Integer id) {
		 productRepository.deleteById(id);
		
	}

	// Inside ProductServiceImplemnt.java
	@Override
	public Product updateProduct(Product product) {
	    // 1. Find the old product in the database using its ID
	    Product existingProduct = productRepository.findById(product.getId())
	            .orElseThrow(() -> new RuntimeException("Product not found"));
	            
	    // 2. Overwrite the old name and price with the new ones the user typed
	    existingProduct.setName(product.getName());
	    existingProduct.setPrice(product.getPrice());
	    
	    // 3. Save it back to MariaDB (Since the ID already exists, it UPDATES instead of creating a new one)
	    return productRepository.save(existingProduct);
	}

}
