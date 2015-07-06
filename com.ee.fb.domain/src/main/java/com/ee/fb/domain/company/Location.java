package com.ee.fb.domain.company;

import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.ee.fb.domain.PersistentObject;
import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "LOCATION")
public class Location extends PersistentObject{

	private static final String Z_JSON_PROPERTY = "z";
	private static final String ZIPCODE_JSON_PROPERTY = "zipCode";
	
	private static final String S_JSON_PROPERTY = "s";
	private static final String STREET_JSON_PROPERTY = "street";
	
	private static final String L_JSON_PROPERTY = "l";
	private static final String LOCATION_JSON_PROPERTY = "location";
	
	@JsonProperty(S_JSON_PROPERTY)
	@Field(STREET_JSON_PROPERTY)
	@Indexed
	private String street;
	
	@JsonProperty(Z_JSON_PROPERTY)
	@Field(ZIPCODE_JSON_PROPERTY)
	@Indexed
	private String zipCode;
	
	@JsonProperty(L_JSON_PROPERTY)
	@Field(LOCATION_JSON_PROPERTY)
	private double[] location;

	@PersistenceConstructor
	public Location(String id, String street, String zipCode, double[] location) {
		super(id);
		this.street = street;
		this.zipCode = zipCode;
		this.location = location;
	}
	
	public Location(String id, String street, String zipCode, double x, double y) {
		super(id);
		this.street = street;
		this.location = new double[]{x, y};
		this.zipCode = zipCode;
	}
	
	public String zipCode(){
		return this.zipCode;
	}

	public String getStreet() {
		return street;
	}

	public double[] getLocation() {
		return location;
	}
}
