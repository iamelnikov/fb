package com.ee.fb.domain.product;

import org.springframework.data.mongodb.core.mapping.Field;

import com.fasterxml.jackson.annotation.JsonProperty;

public class NutritiveValue {

	@JsonProperty("p")
	@Field("protein")
	private double protein;
	
	@JsonProperty("c")
	@Field("carbohydrates")
	private double carbohydrates;
	
	@JsonProperty("f")
	@Field("fates")
	private double fats;

	public NutritiveValue(double protein, double carbohydrates, double fats) {
		super();
		this.protein = protein;
		this.carbohydrates = carbohydrates;
		this.fats = fats;
	}

	public double getProtein() {
		return protein;
	}

	public void setProtein(double protein) {
		this.protein = protein;
	}

	public double getCarbohydrates() {
		return carbohydrates;
	}

	public void setCarbohydrates(double carbohydrates) {
		this.carbohydrates = carbohydrates;
	}

	public double getFats() {
		return fats;
	}

	public void setFats(double fats) {
		this.fats = fats;
	}

}
