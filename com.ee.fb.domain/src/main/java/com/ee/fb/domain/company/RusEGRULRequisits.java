package com.ee.fb.domain.company;

import java.util.Map;

import org.springframework.data.mongodb.core.index.Indexed;
import org.springframework.data.mongodb.core.mapping.Field;

import com.ee.fb.domain.Constants;
import com.ee.fb.domain.PersistentObject;
import com.fasterxml.jackson.annotation.JsonProperty;

public class RusEGRULRequisits extends PersistentObject {

	private static final String INN_JSON_CONSTANT = "inn";
	private static final String KPP_JSON_CONSTANT = "kpp";
	private static final String OKPO_JSON_CONSTANT = "okpo";
	private static final String OGRN_JSON_CONSTANT = "ogrn";
	private static final String OKATO_JSON_CONSTANT = "okato";
	private static final String OKOPF_JSON_CONSTANT = "okopf";
	private static final String OKVED_JSON_CONSTANT = "okved";

	static enum RusEGRULRequisitesEnum {
		INN(INN_JSON_CONSTANT), KPP(KPP_JSON_CONSTANT), OKPO(OKPO_JSON_CONSTANT), 
		OGRN(OGRN_JSON_CONSTANT), OKATO(OKATO_JSON_CONSTANT), 
		OKOPF(OKOPF_JSON_CONSTANT), OKVED(OKVED_JSON_CONSTANT);
		
		private String code;
		
		private RusEGRULRequisitesEnum(String code) {
			this.code = code;
		}; 
		
		public String getCode(){
			return code;
		}
	}
	
	private Map<RusEGRULRequisitesEnum, String> requisitesMap ;

	@JsonProperty(INN_JSON_CONSTANT)
	@Field(INN_JSON_CONSTANT)
	@Indexed
	protected String inn;

	@JsonProperty(KPP_JSON_CONSTANT)
	@Field(KPP_JSON_CONSTANT)
	@Indexed
	protected String kpp;

	@JsonProperty(OKPO_JSON_CONSTANT)
	@Field(OKPO_JSON_CONSTANT)
	@Indexed
	protected String okpo;

	@JsonProperty(OGRN_JSON_CONSTANT)
	@Field(OGRN_JSON_CONSTANT)
	@Indexed
	protected String ogrn;

	@JsonProperty(OKATO_JSON_CONSTANT)
	@Field(OKATO_JSON_CONSTANT)
	@Indexed
	protected String okato;
	
	@JsonProperty(OKOPF_JSON_CONSTANT)
	@Field(OKOPF_JSON_CONSTANT)
	@Indexed
	protected String okopf;
	
	@JsonProperty(OKVED_JSON_CONSTANT)
	@Field(OKVED_JSON_CONSTANT)
	@Indexed
	protected String okved;

	public RusEGRULRequisits(String id, String inn, String kpp, String okpo,
			String ogrn, String okato, String okopf, String okved) {
		super(id);
		this.inn = inn;
		this.kpp = kpp;
		this.okpo = okpo;
		this.ogrn = ogrn;
		this.okato = okato;
		this.okopf = okopf;
		this.okved = okved;
	}

	public String getInn() {
		return inn;
	}

	public void setInn(String inn) {
		this.inn = inn;
	}

	public String getKpp() {
		return kpp;
	}

	public void setKpp(String kpp) {
		this.kpp = kpp;
	}

	public String getOkpo() {
		return okpo;
	}

	public void setOkpo(String okpo) {
		this.okpo = okpo;
	}

	public String getOgrn() {
		return ogrn;
	}

	public void setOgrn(String ogrn) {
		this.ogrn = ogrn;
	}

	public String getOkato() {
		return okato;
	}

	public void setOkato(String okato) {
		this.okato = okato;
	}

	public String getOkopf() {
		return okopf;
	}

	public void setOkopf(String okopf) {
		this.okopf = okopf;
	}

	public String getOkved() {
		return okved;
	}

	public void setOkved(String okved) {
		this.okved = okved;
	}
	
	public String serialize(RusEGRULRequisitesEnum[] order){
		if (order!=null) {
			StringBuffer sb = new StringBuffer();
			for (RusEGRULRequisitesEnum o: order) {
				String val = this.requisitesMap.get(o);
				if (val!=null && val.trim().length()>0) {
					if (sb.length()>0)
						sb.append(", ");
					sb.append(o.code).append(" ").append(val);
				}
			}
			return sb.toString();
		}
		return Constants.EMPTY_STRING;
	}

}
