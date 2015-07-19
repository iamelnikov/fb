package com.ee.fb.dictionary.impl;

import com.ee.core.dictionary.impl.AbstractHierarchicalDictionary;

//@Document(collection = "Dictionary.ProductCategory")
public class ProductCategory extends AbstractHierarchicalDictionary<String, ProductCategory>{

	public ProductCategory(String value, ProductCategory parentCategoryObject) {
		super(value, parentCategoryObject);
	}
	
	public ProductCategory(String id, String value, ProductCategory parentCategoryObject) {
		super(id, value, parentCategoryObject);
	}

}
