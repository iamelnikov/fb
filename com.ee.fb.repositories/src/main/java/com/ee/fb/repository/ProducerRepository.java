package com.ee.fb.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ee.domain.company.Producer;

public interface ProducerRepository extends CrudRepository<Producer, String> {
	public List<Producer> findProducerByFullNameOrShortName(String name);
	public List<Producer> findProducerByRequisitsInnOrRequisitsKppAllIgnoreCase(String inn, String kpp);
	public List<Producer> findProducerByRequisitsOkved(String okved);
}
