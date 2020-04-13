package com.mitocode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mitocode.model.entity.Product;

@Repository("productRepository")
public interface ProductRepository extends JpaRepository<Product, Integer> {

}
