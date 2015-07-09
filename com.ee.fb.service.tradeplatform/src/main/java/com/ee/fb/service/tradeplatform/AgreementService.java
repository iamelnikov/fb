package com.ee.fb.service.tradeplatform;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ee.fb.domain.agreement.Agreement;
import com.ee.fb.domain.agreement.impl.PurchaseAgreementImpl;
import com.ee.fb.repository.AgreementRepository;

@Service
public class AgreementService {

	@Autowired
	private AgreementRepository agreementRepository;
	
	public String createNewPurchaseAgreement() {
		Agreement agreement = 
		agreementRepository.save(arg0)
	}
}
