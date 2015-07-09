package com.ee.fb.domain.product;

import java.util.Map;
import java.util.Set;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

import com.ee.domain.mongo.PersistentObjectImpl;
import com.ee.fb.domain.company.Producer;
import com.fasterxml.jackson.annotation.JsonProperty;

@Document(collection = "PRODUCT")
public class Product extends PersistentObjectImpl {

	private static final String N_JSON_CONSTANT = "n";
	private static final String NAME_JSON_CONSTANT = "name";

	private static final String T_JSON_CONSTANT = "t";
	private static final String TYPE_JSON_CONSTANT = "type";

	private static final String DSC_JSON_CONSTANT = "dsc";
	private static final String DESCRIPTION_JSON_CONSTANT = "description";

	private static final String CMP_JSON_CONSTANT = "cmp";
	private static final String COMPOSITION_JSON_CONSTANT = "composition";

	private static final String THL_JSON_CONSTANT = "thl";
	private static final String TECHNOLOGY_JSON_CONSTANT = "technology";

	private static final String PRD_JSON_CONSTANT = "prd";
	private static final String PRODUCER_JSON_CONSTANT = "producer";

	private static final String CHRS_JSON_CONSTANT = "chrs";
	private static final String CHARACTERISTICS_JSON_CONSTANT = "characteristics";

	private static final String IMGS_JSON_CONSTANT = "imgs";
	private static final String IMAGESIDS_JSON_CONSTANT = "imagesIds";

	@JsonProperty(N_JSON_CONSTANT)
	@Field(NAME_JSON_CONSTANT)
	@Indexed
	protected String name;

	@JsonProperty(T_JSON_CONSTANT)
	@Field(TYPE_JSON_CONSTANT)
	@Indexed
	protected int type;

	@JsonProperty(DSC_JSON_CONSTANT)
	@Field(DESCRIPTION_JSON_CONSTANT)
	protected String description;

	@JsonProperty(CMP_JSON_CONSTANT)
	@Field(COMPOSITION_JSON_CONSTANT)
	protected SimpleProductComposition composition;

	@JsonProperty(THL_JSON_CONSTANT)
	@Field(TECHNOLOGY_JSON_CONSTANT)
	protected Technology technology;

	@JsonProperty(PRD_JSON_CONSTANT)
	@Field(PRODUCER_JSON_CONSTANT)
	protected Producer producer;

	@JsonProperty(CHRS_JSON_CONSTANT)
	@Field(CHARACTERISTICS_JSON_CONSTANT)
	protected Map<String, Double> characteristics;

	@JsonProperty(IMGS_JSON_CONSTANT)
	@Field(IMAGESIDS_JSON_CONSTANT)
	protected Set<String> imageIdSet;

	public Product(String id, String name, int type, Producer producer) {
		super(id);
		this.type = type;
		this.producer = producer;
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public SimpleProductComposition getComposition() {
		return composition;
	}

	public void setComposition(SimpleProductComposition composition) {
		this.composition = composition;
	}

	public Technology getTechnology() {
		return technology;
	}

	public void setTechnology(Technology technology) {
		this.technology = technology;
	}

}
