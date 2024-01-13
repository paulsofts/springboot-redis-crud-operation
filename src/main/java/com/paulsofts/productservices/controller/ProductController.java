package com.paulsofts.productservices.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.paulsofts.productservices.entity.Product;
import com.paulsofts.productservices.service.ProductService;

@RestController
@RequestMapping("/api/product")
public class ProductController {
	
	@Autowired
	private ProductService productService;
	
	@PostMapping("/save")
	public Product saveProduct(@RequestBody Product product) {
		return productService.saveProduct(product);
	}
	
	@GetMapping("/get")
	public List<Product> getAllProducts(){
		return productService.getAllProducts();
	}
	
	@GetMapping("/get/{pdtId}")
	public Product getProduct(@PathVariable int pdtId) {
		System.out.println(productService.getProductById(pdtId));
		return productService.getProductById(pdtId);
	}
	
	@DeleteMapping("/delete/{pdtId}")
	public String deleteProduct(@PathVariable int pdtId) {
		return productService.deleteProduct(pdtId);
	}

}
