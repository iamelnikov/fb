package com.ee.fb.repository;

import java.util.List;

import org.springframework.data.repository.CrudRepository;

import com.ee.fb.domain.company.Producer;

public interface ProducerRepository extends CrudRepository<Producer, String> {
	public List<Producer> findProducerByFullNameOrShortName(String name);
	public List<Producer> findProducerByInnOrKpp(String inn, String kpp);
	public List<Producer> findProducerByOkved(String okved);
}
