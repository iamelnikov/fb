package com.ee.fb.domain.agreement.impl;

import java.util.Date;
import java.util.LinkedHashSet;
import java.util.Set;

import com.ee.fb.domain.agreement.AgreementConsumerInfo;
import com.ee.fb.domain.agreement.AgreementProducerInfo;
import com.ee.fb.domain.agreement.AgreementTerms;
import com.ee.fb.domain.company.Consumer;
import com.ee.fb.domain.company.Producer;
import com.ee.fb.domain.product.Product;
import com.ee.fb.domain.request.ProductOffer;
import com.mongodb.gridfs.GridFSDBFile;

public class PurchaseAgreementImpl extends AbstractAgreement {

	protected Set<PurchaseItem<?>> items = new LinkedHashSet<PurchaseItem<?>>();
	
	public PurchaseAgreementImpl(String id, Producer producer, Consumer consumer, Product... product) {
		super(id, producer, consumer);
	}
	
	public PurchaseAgreementImpl(String id, Producer producer, Consumer consumer, ProductOffer... offer) {
		super(id, producer, consumer);
	}


	@Override
	public Date getSignDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getStartDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Date getEndDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public double getSum() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getCurrency() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public AgreementTerms getAgreementTerms() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void setFile(GridFSDBFile file) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public GridFSDBFile getFile() {
		// TODO Auto-generated method stub
		return null;
	}
}
