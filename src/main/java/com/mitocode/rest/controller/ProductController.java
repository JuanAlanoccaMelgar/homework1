package com.mitocode.rest.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.mitocode.model.entity.Product;
import com.mitocode.service.ProductService;

@RestController
@RequestMapping("/product")
public class ProductController {
	
	@Autowired
	@Qualifier("productService")
	private ProductService productService;
	
	@GetMapping
	public ResponseEntity<List<Product>> listar(){
		List<Product> list = productService.listAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Product> getById(@PathVariable("id") Integer id) {
		Product obj = productService.listById(id);
		return (obj != null ? new ResponseEntity<Product>(obj, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND)); 
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> register(@RequestBody Product product) {
		Product obj = productService.register(product);		
		return (obj != null ? new ResponseEntity<>(HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
	}

}
