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

import com.mitocode.model.entity.Sale;
import com.mitocode.service.SaleService;

@RestController
@RequestMapping("/sale")
public class SaleController {
	
	@Autowired
	@Qualifier("saleService")
	private SaleService saleService;
	
	@GetMapping
	public ResponseEntity<List<Sale>> listar(){
		List<Sale> list = saleService.listAll();
		return new ResponseEntity<>(list, HttpStatus.OK);
	}
	
	@GetMapping("/{id}")
	public ResponseEntity<Sale> getById(@PathVariable("id") Integer id) {
		Sale obj = saleService.listById(id);
		return (obj != null ? new ResponseEntity<>(obj, HttpStatus.OK) : new ResponseEntity<>(HttpStatus.NOT_FOUND)); 
	}
	
	@PostMapping("/create")
	public ResponseEntity<?> register(@RequestBody Sale sale) {
		Sale obj = saleService.register(sale);		
		return (obj != null ? new ResponseEntity<>(HttpStatus.CREATED) : new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR));
	}

}
