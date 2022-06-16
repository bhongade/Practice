package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Category;
import com.example.demo.model.Product;
import com.example.demo.repository.ProductRepository;

@RestController
@RequestMapping("/api")
public class ProductController {

    @Autowired
    ProductRepository productRepository;

    @GetMapping("/product")
    public List<Product> getAllProducts() {
        return productRepository.findAll();
    }
    @PostMapping("/createProduct")
	public Product createProduct(@Valid @RequestBody Product product) {
    	product.setCreateAt(LocalDateTime.now());
		return productRepository.save(product);
	}

	@GetMapping("/getProductById/{id}")
	public Product getProductById(@PathVariable(value = "id") Long productId) {
		return productRepository.findById(productId);
	}

	@PutMapping("/updateProduct/{id}")
	public Product updateProduct(@PathVariable(value = "id") Long productId,

			@Valid @RequestBody Product productDetails) {

		Product product = productRepository.findById(productId);

		product.setProductName(productDetails.getProductName());
		product.setPrice(productDetails.getPrice());
		product.setProductDesc(productDetails.getProductDesc());
		product.setCategoryId(productDetails.getCategoryId());
		return product;
	}

	@DeleteMapping("/deleteProduct/{id}")
	public ResponseEntity<?> deleteProduct(@PathVariable(value = "id") Long productId) {
		Product product = productRepository.findById(productId);

		productRepository.delete(product);

		return ResponseEntity.ok().build();
	}

}
