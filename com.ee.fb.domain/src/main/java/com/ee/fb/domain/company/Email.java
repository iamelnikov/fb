package com.ee.fb.domain.company;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.ee.domain.mongo.PersistentObjectImpl;
import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "EMAIL")
public class Email extends PersistentObjectImpl {

	protected static final String E_JSON_PROPERTY = "e";
	protected static final String EMAIL_JSON_PROPERTY = "email";

	protected static final String N_JSON_PROPERTY = "n";
	protected static final String NAME_JSON_PROPERTY = "name";

	protected static final String D_JSON_PROPERTY = "d";
	protected static final String DESCRIPTION_JSON_PROPERTY = "description";

	@JsonProperty(E_JSON_PROPERTY)
	@Field(EMAIL_JSON_PROPERTY)
	@Indexed
	protected String email;

	@JsonProperty(N_JSON_PROPERTY)
	@Field(NAME_JSON_PROPERTY)
	@Indexed
	protected String name;

	@JsonProperty(D_JSON_PROPERTY)
	@Field(DESCRIPTION_JSON_PROPERTY)
	protected String description;

	public Email(){
		super(null);
	}
	
	public Email(String id, String email, String name, String description) {
		super(id);
		this.email = email;
		this.name = name;
		this.description = description;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
}
