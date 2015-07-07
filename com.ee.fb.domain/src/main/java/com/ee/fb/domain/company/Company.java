package com.ee.fb.domain.company;

import java.util.List;

import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.TextIndexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.ee.fb.domain.PersistentObject;
import com.ee.fb.domain.company.RusEGRULRequisits.RusEGRULRequisitesEnum;
import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "COMPANY")
public abstract class Company extends PersistentObject {

	private static final String FN_JSON_CONSTANT = "fn";
	private static final String FULL_NAME_JSON_CONSTANT = "fullName";
	
	private static final String SN_JSON_CONSTANT = "sn";
	private static final String SHORT_NAME_JSON_CONSTANT = "shortName";
	
	private static final String RQS_JSON_CONSTANT = "rqs";
	private static final String REQUISITS_JSON_CONSTANT = "requisits";
	
	private static final String CLB_JSON_CONSTANT = "clb";
	private static final String COLLABORATION_JSON_CONSTANT = "collaboration";
	
	@JsonProperty(FN_JSON_CONSTANT)
	@Field(FULL_NAME_JSON_CONSTANT)
	@TextIndexed
	protected String fullName;
	
	@JsonProperty(SN_JSON_CONSTANT)
	@Field(SHORT_NAME_JSON_CONSTANT)
	@TextIndexed
	protected String shortName;
	
	@JsonProperty(RQS_JSON_CONSTANT)
	@Field(REQUISITS_JSON_CONSTANT)
	@DBRef
	protected RusEGRULRequisits requisits;
	
	@JsonProperty(CLB_JSON_CONSTANT)
	@Field(COLLABORATION_JSON_CONSTANT)
	@DBRef
	protected Collaboration collaboration;
	
	public Company() {
		super(null);
	}
	
	@PersistenceConstructor
	public Company(String id, String friendlyName, String fullName, String shortName,
			Location legalAddress, Location actualAddress,
			List<Phone> phoneList, String website, int industry) {
		super(id);
		this.fullName = fullName;
		this.shortName = shortName;
	}
	
	public String serialize(String[] properties, RusEGRULRequisitesEnum[] requisits){
		//TODO
		return null;
	};
}
