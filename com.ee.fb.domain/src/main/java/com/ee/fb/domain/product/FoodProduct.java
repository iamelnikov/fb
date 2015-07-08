package com.ee.fb.domain.product;

import org.springframework.data.mongodb.core.mapping.Field;

import com.ee.fb.domain.company.Producer;
import com.fasterxml.jackson.annotation.JsonProperty;

public class FoodProduct extends Product {

	@JsonProperty("nv")
	@Field("nutritiveValue")
	protected NutritiveValue nutritiveValue;
	
	protected static final int foodProductType = 1;

	public FoodProduct(String id, String name, double price, String currency,
			Producer producer) {
		super(id, name, foodProductType, producer);
	}

}
