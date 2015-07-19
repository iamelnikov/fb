package com.ee.fb.dictionary.impl;

import com.ee.core.dictionary.impl.AbstractDictionary;


public class Country extends AbstractDictionary<String> {

	protected String iso2Code;
	protected String iso3Code;
	protected String isoNum;

	public Country(String id, String name, String iso2Code, String iso3Code,
			String isoNum) {
		super(id, name);
		this.iso2Code = iso2Code;
		this.iso3Code = iso3Code;
		this.isoNum = isoNum;
	}

	public String getIso2Code() {
		return iso2Code;
	}

	public String getIso3Code() {
		return iso3Code;
	}

	public String getIsoNum() {
		return isoNum;
	}
}
