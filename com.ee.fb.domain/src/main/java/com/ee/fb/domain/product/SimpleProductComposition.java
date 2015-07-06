package com.ee.fb.domain.product;

import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

import org.springframework.data.mongodb.core.mapping.Field;

import com.ee.fb.domain.PersistentObject;
import com.fasterxml.jackson.annotation.JsonProperty;

public class SimpleProductComposition extends PersistentObject {
	
	@JsonProperty("composition")
	@Field("composition")
	protected Map<String, Double> compositionMap;
	
	public SimpleProductComposition(String id){
		super(id);
		this.compositionMap = new LinkedHashMap<String, Double>();
	}
	
	public void addProductToComposition(String product) {
		this.compositionMap.put(product, null);
	}
	
	public void removeProductToComposition(String product) {
		this.compositionMap.remove(product);
	}
	
	public Set<String> getCompositionList(){
		return Collections.unmodifiableSet(compositionMap.keySet());
	};
}
