package com.ee.fb.domain.product;

import java.util.Date;

import com.ee.domain.mongo.PersistentObjectImpl;

public class ProductCatalogItem extends PersistentObjectImpl{

	private Product product;
	private boolean available;
	private long count;
	private Date expirationDate;
	
	public ProductCatalogItem(String id, Product product, boolean available, long count, Date expirationDate) {
		super(id);
		this.product = product;
		this.available = available;
		this.count = count;
		this.expirationDate = expirationDate;
	}
	
	public Product getProduct(){
		return product;
	}
	
	public Boolean isAvailable(){
		return available;
	}
	
	public long getCount(){
		return this.count;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public void setAvailable(boolean available) {
		this.available = available;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public Date getExpirationDate() {
		return expirationDate;
	}

	public void setExpirationDate(Date expirationDate) {
		this.expirationDate = expirationDate;
	}
}
