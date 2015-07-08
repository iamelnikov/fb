package com.ee.fb.domain.agreement.impl;

import com.ee.fb.domain.agreement.AdditionalAgreement;
import com.ee.fb.domain.agreement.Agreement;
import com.ee.fb.domain.agreement.AgreementConsumerInfo;
import com.ee.fb.domain.agreement.AgreementProducerInfo;

public class AdditionalAgreementImpl extends AbstractAgreement implements
		AdditionalAgreement {

	private Agreement agreement;

	public AdditionalAgreementImpl(String id,
			AgreementProducerInfo producerInfo,
			AgreementConsumerInfo consumerInfo, Agreement agreement) {
		super(id, producerInfo, consumerInfo, null, null, null);
		this.agreement = agreement;
	}

	@Override
	public Agreement getAgreement() {
		return agreement;
	}

}
