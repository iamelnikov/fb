package com.ee.fb.service.tradeplatform;

import java.util.UUID;

import org.apache.commons.lang3.RandomStringUtils;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.ee.domain.company.Producer;
import com.ee.domain.product.Product;
import com.ee.domain.product.ProductImpl;
import com.ee.fb.repository.ProductRepository;

@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class TestProductRepository {

	@Autowired
	private ProductRepository repository;
	private static Product product1;

	@BeforeClass
	public static void init() {
		String pid = UUID.randomUUID().toString();
		String productName = "productName " + RandomStringUtils.random(300);
//		int productType = RandomUtils.nextInt(1, 500);
		Producer producer = null;
		product1 = new ProductImpl(pid, "", productName, "", producer);
	}

	@Test
	public void test1CreateProduct(){
		repository.save(product1);
	}
	
	@Test
	public void test2RetrieveProduct(){
		Product foundProduct = repository.findOne(product1.getId());
		Assert.assertTrue(foundProduct!=null);
		Assert.assertEquals(foundProduct, product1);
				
	}
}
