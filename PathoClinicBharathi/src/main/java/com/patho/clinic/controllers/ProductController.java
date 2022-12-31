package com.patho.clinic.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.patho.clinic.interfaces.IProduct;
import com.patho.clinic.models.Price;
import com.patho.clinic.models.Product;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/api/v1")
public class ProductController {
	
	@Autowired
	private IProduct productService;

	@PostMapping("/product")
	public ResponseEntity<Product> createProduct(@RequestBody Product product) {
		Product _product = productService.addProduct(product);
		return new ResponseEntity<>(_product, HttpStatus.CREATED);
	}
	
	@PostMapping("/productDetails")
	public ResponseEntity<Price> createProductDetails(@RequestBody Price productDetails) {
		Price _price = productService.addProductDetails(productDetails);
		return new ResponseEntity<>(_price, HttpStatus.CREATED);
	}

}
