package com.ee.fb.service.tradeplatform;

import java.util.List;

import com.ee.domain.company.Producer;

public interface ProducerService {

	public String saveProducer(String fullName, String shortName, String inn,
			String kpp, String okved);

	public String saveProducer(Producer producer);

	public void blockProducer(String producerId);

	public void removeProducer(String producerId);

	public List<Producer> findProducer();
}
