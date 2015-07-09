package com.ee.fb.domain.company;

import java.util.LinkedHashSet;
import java.util.List;
import java.util.Set;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

import com.ee.fb.domain.product.Product;
import com.ee.fb.domain.request.ProductOffer;
import com.ee.fb.domain.user.SalesManager;
import com.fasterxml.jackson.annotation.JsonIgnore;

public class Producer extends Company {

	private static final String PRODUCT_JSON_PROPERTY_CONSTANT = "products";
	private static final String MANAGERS_JSON_PROPERTY_CONSTANT = "managers";
	private static final String OFFERS_JSON_PROPERTY_CONSTANT = "offers";

	@JsonIgnore
	@Field(PRODUCT_JSON_PROPERTY_CONSTANT)
	@DBRef
	private Set<Product> products;
	@JsonIgnore
	@Field(MANAGERS_JSON_PROPERTY_CONSTANT)
	@DBRef
	private Set<SalesManager> managers;
	@JsonIgnore
	@Field(OFFERS_JSON_PROPERTY_CONSTANT)
	@DBRef
	private Set<ProductOffer> offers;

	public Producer(String id, String friendlyName, String fullName,
			String shortName, Location legalAddress, Location actualAddress,
			List<Phone> phoneList, String website, int industry) {
		super(id, friendlyName, fullName, shortName, legalAddress,
				actualAddress, phoneList, website, industry);
		this.products = new LinkedHashSet<Product>();
		this.managers = new LinkedHashSet<SalesManager>();
	}

	public void addProduct(Product product) {
		assert this.products != null;
		this.products.add(product);
	}

	public Set<Product> getProducts() {
		return products;
	}

	public void setProducts(Set<Product> products) {
		this.products = products;
	}

	public Set<SalesManager> getManagers() {
		return managers;
	}

	public void setManagers(Set<SalesManager> managers) {
		this.managers = managers;
	}

	public Set<ProductOffer> getOffers() {
		return offers;
	}

	public void setOffers(Set<ProductOffer> offers) {
		this.offers = offers;
	}

	public void addProductOffer(ProductOffer offer) {
		assert this.offers != null;
		this.offers.add(offer);
	}
}
