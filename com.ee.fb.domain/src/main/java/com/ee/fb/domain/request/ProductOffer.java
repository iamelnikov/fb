package com.ee.fb.domain.request;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Field;

import com.ee.fb.domain.PersistentObject;
import com.ee.fb.domain.product.Product;
import com.fasterxml.jackson.annotation.JsonProperty;

public class ProductOffer extends PersistentObject{
	
	private static final String P_JSON_PROPERTY_CONSTANT = "p";
	private static final String PRODUCT_JSON_PROPERTY_CONSTANT = "product";
	
	private static final String PS_JSON_PROPERTY_CONSTANT = "ps";
	private static final String PARTSIZE_JSON_PROPERTY_CONSTANT = "partSize";
	
	private static final String D_JSON_PROPERTY_CONSTANT = "d";
	private static final String DETAILS_JSON_PROPERTY_CONSTANT = "details";
	
	private static final String SM_JSON_PROPERTY_CONSTANT = "sm";
	private static final String SALES_MANAGER_JSON_PROPERTY_CONSTANT = "salesManager";
	
	private static final String OED_JSON_PROPERTY_CONSTANT = "oed";
	private static final String OFFER_END_DATE_JSON_PROPERTY_CONSTANT = "offerEndDate";
	
	private static final String OSD_JSON_PROPERTY_CONSTANT = "osd";
	private static final String OFFER_START_DATE_JSON_PROPERTY_CONSTANT = "offerStartDate";
	
	@JsonProperty(P_JSON_PROPERTY_CONSTANT)
	@Field(PRODUCT_JSON_PROPERTY_CONSTANT)
	@DBRef
	protected Product product;
	
	@JsonProperty(PS_JSON_PROPERTY_CONSTANT)
	@Field(PARTSIZE_JSON_PROPERTY_CONSTANT)
	protected int partSize;
	
	@JsonProperty(D_JSON_PROPERTY_CONSTANT)
	@Field(DETAILS_JSON_PROPERTY_CONSTANT)
	protected String details;
	
	@JsonProperty(SM_JSON_PROPERTY_CONSTANT)
	@Field(SALES_MANAGER_JSON_PROPERTY_CONSTANT)
	protected String salesManagerContact;
	
	@JsonProperty(OED_JSON_PROPERTY_CONSTANT)
	@Field(OFFER_END_DATE_JSON_PROPERTY_CONSTANT)
	protected Date offerEndDate;
	
	@JsonProperty(OSD_JSON_PROPERTY_CONSTANT)
	@Field(OFFER_START_DATE_JSON_PROPERTY_CONSTANT)
	protected Date offerStartDate;
	
	public ProductOffer(String id) {
		super(id);
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getPartSize() {
		return partSize;
	}

	public void setPartSize(int partSize) {
		this.partSize = partSize;
	}

	public String getDetails() {
		return details;
	}

	public void setDetails(String details) {
		this.details = details;
	}

	public String getSalesManagerContact() {
		return salesManagerContact;
	}

	public void setSalesManagerContact(String salesManagerContact) {
		this.salesManagerContact = salesManagerContact;
	}

	public Date getOfferEndDate() {
		return offerEndDate;
	}

	public void setOfferEndDate(Date offerEndDate) {
		this.offerEndDate = offerEndDate;
	}

	public Date getOfferStartDate() {
		return offerStartDate;
	}

	public void setOfferStartDate(Date offerStartDate) {
		this.offerStartDate = offerStartDate;
	}
}
