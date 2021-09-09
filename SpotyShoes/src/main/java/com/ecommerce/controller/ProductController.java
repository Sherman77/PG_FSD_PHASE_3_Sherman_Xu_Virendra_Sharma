package com.ecommerce.controller;

import java.text.SimpleDateFormat;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ecommerce.model.Product;
import com.ecommerce.model.ProductSearchBody;
import com.ecommerce.repository.ProductRepository;
import com.ecommerce.specification.ProductSpecification;
import com.querydsl.core.types.Expression;
import com.querydsl.core.types.Ops;
import com.querydsl.core.types.Path;
import com.querydsl.core.types.dsl.BooleanExpression;
import com.querydsl.core.types.dsl.Expressions;

@RestController
@RequestMapping("products")
public class ProductController {

	@Autowired
	ProductRepository productRepository;
	
	//Get all products
	@GetMapping("all")
	public List<Product> getAllProduct() {
		List<Product> products = (List<Product>) productRepository.findAll();
		return products;
	}
	
	//Add a product
	@PostMapping("add")
	public Product addProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
	
	//Update a product information
	@PutMapping("update/{id}")
	public Product updateProduct(@RequestBody Product product) {
		return productRepository.save(product);
	}
	
	//Delete a product
	@DeleteMapping("delete/{id}")
	public void deleteProduct(@PathVariable int id) {
		productRepository.deleteById(id);
	}
	
	//Search a product by ID
	@GetMapping("product/{id}")
	public Optional<Product> searchProductById(@PathVariable int id) {
		return productRepository.findById(id);
	}
	
	//Search products by field
	@PostMapping("searchByField")
	public List<Product> searchByField(@RequestBody ProductSearchBody productSearchBody) {
		String column = productSearchBody.getField();
		String value = productSearchBody.getValue();
		ProductSpecification ps = new ProductSpecification(column, value);
		return productRepository.findAll(ps);
	}
	
}
