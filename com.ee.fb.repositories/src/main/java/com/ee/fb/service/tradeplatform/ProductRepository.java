package com.ee.fb.service.tradeplatform;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ee.fb.domain.product.Product;

public interface ProductRepository extends CrudRepository<Product, String> {
	
	public Product findProductById(String id);
	public List<Product> findProductByProducerId(String producerId);
}