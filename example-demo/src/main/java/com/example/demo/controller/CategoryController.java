package com.example.demo.controller;

import java.time.LocalDateTime;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.Category;
import com.example.demo.repository.CategoryRepository;
import com.example.dto.CategoryDto;

@RestController
@CrossOrigin(origins = "http://localhost:4300")
@RequestMapping("/api")
public class CategoryController {

	@Autowired
	private CategoryRepository categoryRepository;

	@GetMapping("/category")
	public List<Category> getAllCategories() {
		return categoryRepository.findAll();
	}

	@PostMapping("/createCategory")
	public Category createCategory(@RequestBody CategoryDto category) {
		Category categoryNew = new Category();
		categoryNew.setCREATE_AT(LocalDateTime.now());
		categoryNew.setUPDATE_AT(LocalDateTime.now());
		categoryNew.setCATEGARY_NAME(category.getCATEGARY_NAME());
		return categoryRepository.save(categoryNew);
	}

	@GetMapping("/getCategoryById/{id}")
	public Category getCategoryById(@PathVariable(value = "id") Long categoryId) {
		return categoryRepository.findById(categoryId);
	}

	@PutMapping("/updateCategory/{id}")
	public Category updateCategory(@PathVariable(value = "id") Long categoryId,

			@Valid @RequestBody Category categoryDetails) {

		Category category = categoryRepository.findById(categoryId);
        
		category.setCATEGARY_NAME(categoryDetails.getCATEGARY_NAME());
	    category.setUPDATE_AT(LocalDateTime.now());
		Category  CREATE_ATCategory = categoryRepository.save(category);
		return  CREATE_ATCategory;
	}

	@DeleteMapping("/deleteCategory/{id}")
	public ResponseEntity<?> deleteCategory(@PathVariable(value = "id") Long categoryId) {
		Category category = categoryRepository.findById(categoryId);

		categoryRepository.delete(category);

		return ResponseEntity.ok().build();
	}

}
