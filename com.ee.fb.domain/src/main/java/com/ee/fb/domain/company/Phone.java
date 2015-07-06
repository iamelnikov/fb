package com.ee.fb.domain.company;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.ee.fb.domain.PersistentObject;
import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "PHONE")
public class Phone extends PersistentObject{
	
	protected static final String T_JSON_PROPERTY = "t";
	protected static final String TYPE_JSON_PROPERTY = "type";
	
	protected static final String P_JSON_PROPERTY = "p";
	protected static final String PHONE_JSON_PROPERTY = "phone";
	
	@JsonProperty(T_JSON_PROPERTY)
	@Field(TYPE_JSON_PROPERTY)
	private String type;
	
	@JsonProperty(P_JSON_PROPERTY)
	@Field(PHONE_JSON_PROPERTY)
	private String phone;
	
	public Phone(String id, String type) {
		super(id);
		this.type = type;
	}

	public String getType() {
		return type;
	}

	public String getPhone() {
		return phone;
	}
}
