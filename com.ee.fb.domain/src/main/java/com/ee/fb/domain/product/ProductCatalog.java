package com.ee.fb.domain.product;

import java.util.LinkedList;
import java.util.List;

import com.ee.fb.domain.company.Producer;

public class ProductCatalog {

	private Producer producer;
	private List<ProductCatalogItem> items;

	public ProductCatalog(Producer producer, List<ProductCatalogItem> items) {
		this.producer = producer;
		this.items = items;
	}

	public ProductCatalog(Producer producer) {
		this.producer = producer;
		this.items = new LinkedList<ProductCatalogItem>();
	}

	public Producer getProducer() {
		return this.producer;
	}

	public List<ProductCatalogItem> getProductCatalogItems() {
		if (this.items == null)
			this.items = new LinkedList<ProductCatalogItem>();
		return this.items;
	}
	
	public void addProductCatalogItem(ProductCatalogItem item) {
		this.getProductCatalogItems().add(item);
	}

}
