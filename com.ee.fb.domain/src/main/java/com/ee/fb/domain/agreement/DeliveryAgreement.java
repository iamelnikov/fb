package com.ee.fb.domain.agreement;

import com.ee.fb.domain.company.Consumer;

import com.ee.fb.domain.company.Producer;

public class DeliveryAgreement extends AbstractAgreement {

	public DeliveryAgreement(String id, Producer producer, Consumer consumer) {
		super(id, producer, consumer);
	}

}
