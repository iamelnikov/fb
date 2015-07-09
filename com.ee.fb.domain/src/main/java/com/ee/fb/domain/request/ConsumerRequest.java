package com.ee.fb.domain.request;

import java.util.Date;

import org.springframework.data.annotation.PersistenceConstructor;
import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.DBRef;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.ee.domain.mongo.PersistentObjectImpl;
import com.ee.fb.domain.company.Consumer;
import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "CONSUMER_REQUEST")
public class ConsumerRequest extends PersistentObjectImpl {

	private static final String C_JSON_PROPERTY_CONSTANT = "c";
	private static final String CONSUMER_JSON_PROPERTY_CONSTANT = "consumer";

	private static final String D_JSON_PROPERTY_CONSTANT = "d";
	private static final String DESCRIPTION_JSON_PROPERTY_CONSTANT = "description";

	private static final String PN_JSON_PROPERTY_CONSTANT = "pn";
	private static final String PRODUCT_NAME_JSON_PROPERTY_CONSTANT = "productName";
	
	private static final String PT_JSON_PROPERTY_CONSTANT = "pt";
	private static final String PRODUCT_TYPE_JSON_PROPERTY_CONSTANT = "productType";

	private static final String RD_JSON_PROPERTY_CONSTANT = "rd";
	private static final String REQUESTDATE_NAME_JSON_PROPERTY_CONSTANT = "requestDate";

	private static final String S_JSON_PROPERTY_CONSTANT = "s";
	private static final String STATE_NAME_JSON_PROPERTY_CONSTANT = "state";
	
	private static final String CNT_JSON_PROPERTY_CONSTANT = "cnt";
	private static final String COUNT_JSON_PROPERTY_CONSTANT = "count";
	
	private static final String MT_JSON_PROPERTY_CONSTANT = "mt";
	private static final String MEASURE_TYPE_JSON_PROPERTY_CONSTANT = "measureType";

	@JsonProperty(C_JSON_PROPERTY_CONSTANT)
	@Field(CONSUMER_JSON_PROPERTY_CONSTANT)
	@DBRef
	private Consumer consumer;

	@JsonProperty(D_JSON_PROPERTY_CONSTANT)
	@Field(DESCRIPTION_JSON_PROPERTY_CONSTANT)
	private String description;

	@JsonProperty(PN_JSON_PROPERTY_CONSTANT)
	@Field(PRODUCT_NAME_JSON_PROPERTY_CONSTANT)
	@Indexed
	private String productName;
	
	@JsonProperty(PT_JSON_PROPERTY_CONSTANT)
	@Field(PRODUCT_TYPE_JSON_PROPERTY_CONSTANT)
	private int productType;

	@JsonProperty(RD_JSON_PROPERTY_CONSTANT)
	@Field(REQUESTDATE_NAME_JSON_PROPERTY_CONSTANT)
	@Indexed
	private Date requestDate;

	@JsonProperty(CNT_JSON_PROPERTY_CONSTANT)
	@Field(COUNT_JSON_PROPERTY_CONSTANT)
	@Indexed
	private double count;
	
	@JsonProperty(MT_JSON_PROPERTY_CONSTANT)
	@Field(MEASURE_TYPE_JSON_PROPERTY_CONSTANT)
	@Indexed
	private int measureType;
	
	@JsonProperty(S_JSON_PROPERTY_CONSTANT)
	@Field(STATE_NAME_JSON_PROPERTY_CONSTANT)
	@Indexed
	private ConsumerRequestState state;

	@PersistenceConstructor
	public ConsumerRequest(String id, Consumer consumer, String description,
			String productName) {
		super(id);
		this.consumer = consumer;
		this.state = ConsumerRequestState.OPEN;
	}

	public Consumer getConsumer() {
		return consumer;
	}

	public void close() {
		this.state = ConsumerRequestState.CLOSED;
	}

	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

}
