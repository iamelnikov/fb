package com.ee.fb.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ee.domain.agreement.Agreement;

public interface AgreementRepository extends CrudRepository<Agreement<?>, String>{
	public Agreement<?> findAgreementByNumber(String number);
	public List<Agreement<?>> findAgreementByProducerInfoProducerId(String producerId);
}
