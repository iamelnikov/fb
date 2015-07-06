package com.ee.fb.domain.product;

import com.ee.fb.domain.PersistentObject;

public class ProductCatalogItem extends PersistentObject{

	private Product product;
	private boolean available;
	private long count;
	
	public ProductCatalogItem(String id, Product product, boolean available, long count) {
		super(id);
		this.product = product;
		this.available = available;
		this.count = count;
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
}
