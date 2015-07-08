package com.ee.fb.domain.agreement.impl;

import java.util.LinkedHashSet;
import java.util.Set;

import com.ee.fb.domain.agreement.AgreementConsumerInfo;
import com.ee.fb.domain.agreement.AgreementProducerInfo;
import com.ee.fb.domain.product.Product;
import com.ee.fb.domain.request.ProductOffer;

public class PurchaseAgreementImpl extends AbstractAgreement {

	protected Set<PurchaseItem<?>> items = new LinkedHashSet<PurchaseItem<?>>();
	
	public PurchaseAgreementImpl(String id, AgreementProducerInfo producerInfo, AgreementConsumerInfo consumerInfo, Product... product) {
		super(id, producerInfo, consumerInfo, null, null, null);
	}
	
	public PurchaseAgreementImpl(String id, AgreementProducerInfo producerInfo, AgreementConsumerInfo consumerInfo, ProductOffer... offer) {
		super(id, producerInfo, consumerInfo, null, null, null);
	}


}