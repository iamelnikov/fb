package com.ee.fb.domain.core.search;

public class Filter {
	
	protected String companyName;
	protected int orgType;
	protected int industry;
	protected int industry2;
	protected String productName;
	protected int productType;
	protected int productPrice;
	
	public Filter(String companyName, int orgType, int industry, int industry2,
			String productName, int productType, int productPrice) {
		super();
		this.companyName = companyName;
		this.orgType = orgType;
		this.industry = industry;
		this.industry2 = industry2;
		this.productName = productName;
		this.productType = productType;
		this.productPrice = productPrice;
	}
	
}
