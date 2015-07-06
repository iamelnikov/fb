package com.ee.fb.domain.agreement;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.ee.fb.domain.PersistentObject;
import com.ee.fb.domain.company.Consumer;
import com.ee.fb.domain.company.Producer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mongodb.gridfs.GridFSDBFile;

@Document(collection = "AGREEMENT")
public abstract class AbstractAgreement extends PersistentObject implements
		Agreement {

	private static final String PRD_JSON_PROPERTY = "prd";
	private static final String PRODUCER_JSON_PROPERTY = "producer";

	private static final String CNS_JSON_PROPERTY = "cns";
	private static final String CONSUMER_JSON_PROPERTY = "consumer";

	@Field(PRD_JSON_PROPERTY)
	@JsonProperty(PRODUCER_JSON_PROPERTY)
	protected Producer producer;

	@Field(CNS_JSON_PROPERTY)
	@JsonProperty(CONSUMER_JSON_PROPERTY)
	protected Consumer consumer;

	private GridFSDBFile agreementFile;

	public AbstractAgreement(String id, Producer producer, Consumer consumer) {
		super(id);
		this.producer = producer;
		this.consumer = consumer;
	}

	public Producer getProducer() {
		return producer;
	}

	public void setProducer(Producer producer) {
		this.producer = producer;
	}

	public Consumer getConsumer() {
		return consumer;
	}

	public void setConsumer(Consumer consumer) {
		this.consumer = consumer;
	}

	public GridFSDBFile getAgreementFile() {
		return agreementFile;
	}

	public void setAgreementFile(GridFSDBFile agreementFile) {
		this.agreementFile = agreementFile;
	}

}
