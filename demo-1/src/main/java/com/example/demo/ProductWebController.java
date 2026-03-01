package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ProductWebController {
	
	@Autowired
	private ProductService service;
	
	@GetMapping("/addproduct")
	public String showAddProductForm(Model model) {
		model.addAttribute("product", new Product());
		
		return "addproduct";
	}
	
	@PostMapping("/saveProduct")
    public String saveProduct(@ModelAttribute("product") Product product) {
        
        service.createProduct(product);
        return "redirect:/viewallproduct"; 
    }
	
	@GetMapping("/viewallproduct")
    public String viewallproduct(Model model) {
        model.addAttribute("allproducts", service.getAllProducts());
        return "viewallproduct";
    }
	
	@GetMapping("/deleteproduct/{id}")
    public String deleteProduct(@PathVariable Integer id) {
        // 1. Tell the Chef to delete the item from the database
        service.deleteProduct(id);
        
        // 2. Redirect the user back to the updated table
        return "redirect:/viewallproduct"; 
    }
	
	
	@GetMapping("/deleteproduct")
	public String showDeleteProductForm() {
	    return "deleteproduct";
	}
	
	@PostMapping("/deleteproduct")
	public String deleteProductById(@RequestParam("id") Integer id) {
	    service.deleteProduct(id);
	    return "redirect:/viewallproduct";
	}
	
	// THE RECEIVER: Catches the updated form and saves it
    @PostMapping("/saveupdate")
    public String saveUpdatedProduct(@ModelAttribute("product") Product product) {
        // Because the ID already exists in the database, Hibernate is smart enough 
        // to UPDATE the existing row instead of creating a new one!
        service.updateProduct(product); 
        return "redirect:/viewallproduct";
    }
    
 // Inside ProductController.java
    @GetMapping("/updateproductform/{id}")
    public String updateProductForm(@PathVariable Integer id, Model model) {
        // Ask the Chef to find the specific product (e.g., ID 101)
        Product product = service.getProductById(id);
        
        // Pack that product into the suitcase and send it to the HTML page
        model.addAttribute("product", product);
        
        return "updateproductform";
    }
    
    @GetMapping("/")
    public String home() {
    	return "home";
    }
	
}
