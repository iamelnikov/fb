package com.ee.fb.domain.agreement.impl;

import com.ee.fb.domain.agreement.AgreementConsumerInfo;
import com.ee.fb.domain.agreement.AgreementProducerInfo;

public class DeliveryAgreementImpl extends AbstractAgreement {

	public DeliveryAgreementImpl(String id, AgreementProducerInfo producerInfo, AgreementConsumerInfo consumerInfo) {
		super(id, producerInfo, consumerInfo, null, null,null);
	}
}
