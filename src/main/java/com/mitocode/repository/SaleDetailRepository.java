package com.mitocode.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.mitocode.model.entity.SaleDetail;

@Repository("saleDetailRepository")
public interface SaleDetailRepository extends JpaRepository<SaleDetail, Integer> {

}
