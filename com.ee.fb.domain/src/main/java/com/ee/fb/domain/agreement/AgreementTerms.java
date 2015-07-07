package com.ee.fb.domain.agreement;

public interface AgreementTerms {
	public int getConsumerRequestDays();
	public int getProducerRequestReviewDays();
	public int getConsumerClaimDays();
	public int getProducerClaimReviewDays();
	public int getDeliveryType();
	
}
