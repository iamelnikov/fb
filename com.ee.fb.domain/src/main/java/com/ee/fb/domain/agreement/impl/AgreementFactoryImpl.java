package com.ee.fb.domain.agreement.impl;

import java.util.UUID;

import com.ee.fb.domain.agreement.Agreement;
import com.ee.fb.domain.agreement.AgreementFactory;
import com.ee.fb.domain.agreement.AgreementProducerInfo;
import com.ee.fb.domain.company.Producer;

public class AgreementFactoryImpl implements AgreementFactory {

	@Override
	public Agreement createPurchaseAgreement(Producer producer) {
		String uuid = UUID.randomUUID().toString();
		AgreementProducerInfo pi = new   
		Agreement agr = new PurchaseAgreementImpl(uuid, producerInfo, consumerInfo, product)
	}

	@Override
	public Agreement createAdditionalAgreement() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Agreement createDeliveryAgreement() {
		// TODO Auto-generated method stub
		return null;
	}

}
