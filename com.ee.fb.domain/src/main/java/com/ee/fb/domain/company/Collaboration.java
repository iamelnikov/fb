package com.ee.fb.domain.company;

import java.util.LinkedHashSet;
import java.util.Set;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;

import com.ee.domain.mongo.PersistentObjectImpl;
import com.fasterxml.jackson.annotation.JsonProperty;

public class Collaboration extends PersistentObjectImpl {

	protected static final String ADDRESS_JSON_CONSTANT = "a";
	protected static final String PHONE_JSON_CONSTANT = "p";
	protected static final String EMAIL_JSON_CONSTANT = "e";
	protected static final String WEBADDRESS_JSON_CONSTANT = "w";

	@JsonProperty(ADDRESS_JSON_CONSTANT)
	@Field(ADDRESS_JSON_CONSTANT)
	protected Set<Location> locationSet = new LinkedHashSet<Location>();

	@JsonProperty(PHONE_JSON_CONSTANT)
	@Field(PHONE_JSON_CONSTANT)
	protected Set<Phone> phoneSet = new LinkedHashSet<Phone>();

	@JsonProperty(EMAIL_JSON_CONSTANT)
	@Field(EMAIL_JSON_CONSTANT)
	protected Set<Email> emailSet = new LinkedHashSet<Email>();

	@JsonProperty(WEBADDRESS_JSON_CONSTANT)
	@Field(WEBADDRESS_JSON_CONSTANT)
	@Indexed
	protected String webAddress;

	public Collaboration(String id) {
		super(id);
	}

	public String getWebAddress() {
		return webAddress;
	}

	public void setWebAddress(String webAddress) {
		this.webAddress = webAddress;
	}

	public Set<Location> getLocationSet() {
		if (this.locationSet == null)
			this.locationSet = new LinkedHashSet<Location>();

		return locationSet;
	}

	public Set<Phone> getPhoneSet() {
		if (this.phoneSet == null)
			this.phoneSet = new LinkedHashSet<Phone>();

		return phoneSet;
	}

	public Set<Email> getEmailSet() {
		if (this.emailSet == null)
			this.emailSet = new LinkedHashSet<Email>();

		return emailSet;
	}
}
