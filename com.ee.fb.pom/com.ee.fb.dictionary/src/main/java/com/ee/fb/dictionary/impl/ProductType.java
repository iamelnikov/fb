package com.ee.fb.dictionary.impl;

import com.ee.core.dictionary.impl.AbstractLinkedDictionary;

//@Document(collection = "Dictionary.ProductType")
public class ProductType extends
		AbstractLinkedDictionary<String, ProductCategory> {

	public ProductType(String value, ProductCategory productCategory) {
		super(value, productCategory);
	}

	public ProductType(String id, String value, ProductCategory productCategory) {
		super(id, value, productCategory);
	}
}
