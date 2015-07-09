package com.ee.fb.domain.agreement;

public interface AgreementFactory {

	public Agreement createPurchaseAgreement();
	public Agreement createAdditionalAgreement();
	public Agreement createDeliveryAgreement();
}
