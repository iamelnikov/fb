package com.ee.fb.service.tradeplatform;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ee.domain.agreement.Agreement;
import com.ee.domain.agreement.AgreementFactory;
import com.ee.domain.company.Consumer;
import com.ee.domain.company.Employee;
import com.ee.domain.product.Product;
import com.ee.fb.repository.AgreementRepository;
import com.ee.fb.repository.ConsumerRepository;
import com.ee.fb.repository.EmployeeRepository;
import com.ee.fb.repository.ProducerRepository;
import com.ee.fb.repository.ProductRepository;

@Service
public class AgreementService {

	@Autowired
	private AgreementFactory factory;

	@Autowired
	private AgreementRepository agreementRepository;

	@Autowired
	private EmployeeRepository employeeRepository;

	@Autowired
	private ProducerRepository producerRepository;

	@Autowired
	private ConsumerRepository consumerRepository;
	
	@Autowired
	private ProductRepository productRepository;

	public String createNewPurchaseAgreementWithOneProduct(String producerId,
			String producerResponsiblePersonId, String consumerId,
			String cosnumerSignerId, String productId, double count) {
		com.ee.domain.company.Producer producer = producerRepository.findOne(producerId);
		assert producer != null;

		Employee producerRepsonsibleEmployee = employeeRepository
				.findOne(producerResponsiblePersonId);
		assert producerRepsonsibleEmployee != null;

		Consumer consumer = consumerRepository.findOne(consumerId);
		assert consumer != null;

		Employee consumerSigner = employeeRepository.findOne(cosnumerSignerId);
		assert consumerSigner != null;

		Product product = productRepository.findOne(productId);
		assert product!=null;
		
		Agreement<?> pAgreement = factory.createPurchaseAgreement(producer, producerRepsonsibleEmployee,
				consumer, consumerSigner, product);
		assert pAgreement!=null;
		
		pAgreement = agreementRepository.save(pAgreement);
		assert pAgreement!=null;
		
		return pAgreement.getId();
	}
	
	
}
