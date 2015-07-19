package com.ee.fb.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ee.domain.product.Product;

public interface ProductRepository extends CrudRepository<Product, String> {
	
	public Product findProductById(String id);
	public List<Product> findProductByProducerId(String producerId);
}
