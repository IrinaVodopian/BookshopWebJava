package com.bookshop.controller;

import com.bookshop.model.Product;
import com.bookshop.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Configuration
@RestController
@RequestMapping("/product")
public class ProductController {

	@Autowired
	public ProductService productService;

	@GetMapping
	public List<Product> getListOfProduct() {
		return productService.getAllProducts();
	}

	//add to schema
	@GetMapping("/{productId}")
	public Product getProductById(@PathVariable Integer productId) {
		return productService.getProductById(productId);
	}

	@PostMapping
	public Product addProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}

	@PutMapping("/{productId}")
	public Product editProduct(@RequestBody Product product, @PathVariable Integer productId) {
		return productService.editProduct(product, productId);
	}

	@DeleteMapping("/{productId}")
	void deleteProductById(@PathVariable Integer productId) {
		productService.deleteProductById(productId);
	}

}