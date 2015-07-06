package com.ee.fb.domain.product;

import java.util.Collection;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class ProductComposition<T extends Product> extends
		ProductCompositionNoCount<T> {

	public ProductComposition(String id) {
		super(id);
	}

	public void addProductToComposition(T product, Double count) {
		this.existingProductCompositionMap.put(product, count);
	}

	public void addProductToComposition(String product, Double count) {
		this.compositionMap.put(product, count);
	}

	public Map<String, Double> getCompositionMap() {
		Map<String, Double> map = new LinkedHashMap<String, Double>();
		if (this.existingProductCompositionMap != null
				&& !this.existingProductCompositionMap.isEmpty()) {
			Map<String, Double> existingProductMap = this.existingProductCompositionMap
					.entrySet()
					.stream()
					.collect(
							Collectors.toMap(e -> e.getKey().getName(),
									e -> e.getValue(), (a, b) -> a + b));

			map.putAll(existingProductMap);
		}
		if (this.compositionMap != null && !this.compositionMap.isEmpty()) {
			map = Stream
					.of(map, this.compositionMap)
					.map(Map::entrySet)
					.flatMap(Collection::stream)
					.collect(
							Collectors.toMap(Map.Entry::getKey,
									Map.Entry::getValue, (a, b) -> a + b));
		}
		return map;
	};
}
