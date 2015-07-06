package com.ee.fb.domain.product;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.LinkedHashSet;
import java.util.Map;
import java.util.Set;
import java.util.stream.Collectors;

public class ProductCompositionNoCount<T extends Product> extends
		SimpleProductComposition {
	protected Map<T, Double> existingProductCompositionMap;

	public ProductCompositionNoCount(String id) {
		super(id);
		this.existingProductCompositionMap = new LinkedHashMap<T, Double>();
	}

	public void addProductToComposition(T product) {
		this.existingProductCompositionMap.put(product, null);
	}

	@Override
	public Set<String> getCompositionList() {
		Set<String> set = new LinkedHashSet<String>();
		if (this.existingProductCompositionMap != null
				&& !this.existingProductCompositionMap.isEmpty()) {
			Set<String> existingProductNameSet = this.existingProductCompositionMap
					.entrySet().stream().map(e -> e.getKey().getName())
					.collect(Collectors.toSet());
			set.addAll(existingProductNameSet);
		}
		if (this.compositionMap != null && !this.compositionMap.isEmpty())
			set.addAll(this.compositionMap.keySet());

		return Collections.unmodifiableSet(set);
	};
}
