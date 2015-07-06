package com.ee.fb.domain.agreement;

import java.util.LinkedHashSet;
import java.util.Set;

import com.ee.fb.domain.company.Consumer;
import com.ee.fb.domain.company.Producer;
import com.ee.fb.domain.product.Product;
import com.ee.fb.domain.request.ProductOffer;

public class PurchaseAgreement extends AbstractAgreement {

	protected Set<PurchaseItem<?>> items = new LinkedHashSet<PurchaseItem<?>>();
	
	public PurchaseAgreement(String id, Producer producer, Consumer consumer, Product... product) {
		super(id, producer, consumer);
	}
	
	public PurchaseAgreement(String id, Producer producer, Consumer consumer, ProductOffer... offer) {
		super(id, producer, consumer);
	}
}
