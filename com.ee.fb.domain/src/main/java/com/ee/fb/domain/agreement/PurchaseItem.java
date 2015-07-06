package com.ee.fb.domain.agreement;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

import com.ee.fb.domain.product.Product;
import com.fasterxml.jackson.annotation.JsonProperty;

public class PurchaseItem<T extends Number> {

	private static final String P_JSON_PROPERTY = "p";
	private static final String PRODUCT_JSON_PROPERTY = "product";

	private static final String C_JSON_PROPERTY = "c";
	private static final String COUNT_JSON_PROPERTY = "count";

	@Field(P_JSON_PROPERTY)
	@JsonProperty(PRODUCT_JSON_PROPERTY)
	@DBRef
	private Product product;

	@JsonProperty(C_JSON_PROPERTY)
	@Field(COUNT_JSON_PROPERTY)
	private T count;

	public PurchaseItem(Product product) {
		super();
		this.product = product;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public T getCount() {
		return count;
	}

	public void setCount(T count) {
		this.count = count;
	}
}
