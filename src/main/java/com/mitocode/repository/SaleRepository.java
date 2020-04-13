package com.mitocode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mitocode.model.entity.Sale;

@Repository("saleRepository")
public interface SaleRepository extends JpaRepository<Sale, Integer> {

}
