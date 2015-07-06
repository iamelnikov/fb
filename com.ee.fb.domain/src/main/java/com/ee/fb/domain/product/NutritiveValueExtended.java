package com.ee.fb.domain.product;

import java.util.LinkedHashMap;
import java.util.Map;

public class NutritiveValueExtended extends NutritiveValue {

	private Map<String, Double> map;

	public NutritiveValueExtended(double protein, double carbohydrates,
			double fates) {
		super(protein, carbohydrates, fates);
	}

	private void initMapIfNeeded() {
		if (this.map == null)
			this.map = new LinkedHashMap<String, Double>();
	}

	public void addOtherNutritiveValue(String nutritiveName, Double value) {
		initMapIfNeeded();
		assert this.map != null;
		this.map.put(nutritiveName, value);
	}

}
