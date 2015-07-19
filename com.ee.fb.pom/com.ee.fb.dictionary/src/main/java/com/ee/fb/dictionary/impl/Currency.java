package com.ee.fb.dictionary.impl;

import com.ee.core.dictionary.impl.AbstractDictionary;

//@Document(collection = "Dictionary.Currency")
public class Currency extends AbstractDictionary<String>{

	protected String isoCode;
	protected String isoNum;
	
	public Currency(String id, String name, String isoCode3){
		super(id, name);
	}
}
