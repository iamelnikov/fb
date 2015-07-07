package com.ee.fb.domain.agreement.impl;

import com.ee.fb.domain.company.Consumer;
import com.ee.fb.domain.company.Producer;

public abstract class SupplyChain extends AbstractAgreement {
	
	public SupplyChain(String id, Producer producer, Consumer consumer){
		super(id, producer, consumer);
	}
}
