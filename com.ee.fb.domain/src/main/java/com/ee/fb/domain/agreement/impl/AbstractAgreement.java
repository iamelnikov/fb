package com.ee.fb.domain.agreement.impl;

import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.ee.fb.domain.PersistentObject;
import com.ee.fb.domain.agreement.Agreement;
import com.ee.fb.domain.agreement.AgreementConsumerInfo;
import com.ee.fb.domain.agreement.AgreementProducerInfo;
import com.ee.fb.domain.company.Consumer;
import com.ee.fb.domain.company.Producer;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.mongodb.gridfs.GridFSDBFile;

@Document(collection = "AGREEMENT")
public abstract class AbstractAgreement extends PersistentObject implements
		Agreement {

	static enum AgreementState {
		DRAFT(0), ACTIVE(1), CLOSED(1);
		
		private AgreementState(int code) {
			this.code = code;
		}
		private int code;
	}
	
	private static final String PRD_JSON_PROPERTY = "prd";
	private static final String PRODUCER_JSON_PROPERTY = "producer";

	private static final String CNS_JSON_PROPERTY = "cns";
	private static final String CONSUMER_JSON_PROPERTY = "consumer";

	protected 
	
	@Field(PRD_JSON_PROPERTY)
	@JsonProperty(PRODUCER_JSON_PROPERTY)
	protected Producer producer;

	@Field(CNS_JSON_PROPERTY)
	@JsonProperty(CONSUMER_JSON_PROPERTY)
	protected Consumer consumer;

	protected GridFSDBFile agreementFile;
	
	protected AgreementState state;

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
	
	@Override
	public String getCity() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getNumber() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AgreementProducerInfo getProducerInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public AgreementConsumerInfo getConsumerInfo() {
		// TODO Auto-generated method stub
		return null;
	}
	
	@Override
	public int getState() {
		return this.state.code;
	}

	@Override
	public void activate() {
		this.state = AgreementState.ACTIVE;
	}

	@Override
	public void close() {
		this.state = AgreementState.CLOSED;
	}

}
