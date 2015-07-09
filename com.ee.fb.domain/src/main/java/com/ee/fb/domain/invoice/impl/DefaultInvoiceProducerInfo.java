package com.ee.fb.domain.invoice.impl;

import com.ee.domain.mongo.PersistentObjectImpl;
import com.ee.fb.domain.company.Producer;
import com.ee.fb.domain.invoice.InvoiceProducerInfo;

public class DefaultInvoiceProducerInfo extends PersistentObjectImpl implements InvoiceProducerInfo{

	protected Producer producer;
	
	public DefaultInvoiceProducerInfo(String id, Producer producer) {
		super(id);
		this.producer = producer;
	}
	
	@Override
	public String getFullInvoiceProducerInfo() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getProducerFullName() {
		// TODO Auto-generated method stub
		return null;
	}

}
