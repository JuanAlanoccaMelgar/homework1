package com.mitocode.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mitocode.model.entity.Product;
import com.mitocode.repository.ProductRepository;
import com.mitocode.service.ProductService;

@Service("productService")
public class ProductServiceImpl implements ProductService {
	
	@Autowired
	@Qualifier("productRepository")
	private ProductRepository productRepository;

	@Override
	public Product register(Product obj) {
		return productRepository.save(obj);
	}

	@Override
	public Product modify(Product obj) {
		return productRepository.save(obj);
	}

	@Override
	public List<Product> listAll() {
		return productRepository.findAll();
	}

	@Override
	public Product listById(Integer id) {
		Optional<Product> obj = productRepository.findById(id);
		return obj.isPresent() ? obj.get() : null;
	}

	@Override
	public boolean remove(Integer id) {
		productRepository.deleteById(id);
		return true;
	}

}
