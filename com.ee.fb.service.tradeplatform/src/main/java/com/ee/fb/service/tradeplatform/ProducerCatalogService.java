package com.ee.fb.service.tradeplatform;

import java.util.List;

import com.ee.fb.domain.core.search.Filter;
import com.ee.fb.domain.product.Product;

public interface ProducerCatalogService {

	public String saveProductInCatalog(String name, int type, double price,
			int currency, String producerId);

	public String saveProductInCatalog(Product product);

	public List<Product> getProducerProductCatalogById(String producerId);

	public List<Product> getProducerProductCatalogByType(String producerId,
			int type);

	public List<Product> findProductByFilter(Filter filter);

	public void removeProductFromCatalog(String productId);
	
}
