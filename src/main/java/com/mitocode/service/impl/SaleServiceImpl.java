package com.mitocode.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mitocode.model.entity.Sale;
import com.mitocode.repository.SaleRepository;
import com.mitocode.service.SaleService;

@Service("saleService")
public class SaleServiceImpl implements SaleService {
	
	@Autowired
	@Qualifier("saleRepository")
	private SaleRepository saleRepository;

	@Override
	public Sale register(Sale obj) {		
		obj.getSaleDetail().forEach(dtl -> dtl.setSale(obj));		
		return saleRepository.save(obj);
	}

	@Override
	public Sale modify(Sale obj) {
		return saleRepository.save(obj);
	}

	@Override
	public List<Sale> listAll() {
		return saleRepository.findAll();
	}

	@Override
	public Sale listById(Integer id) {
		Optional<Sale> obj = saleRepository.findById(id);
		return obj.isPresent() ? obj.get() : null;
	}

	@Override
	public boolean remove(Integer id) {
		saleRepository.deleteById(id);
		return true;
	}

}
