package com.ee.fb.domain.invoice;

import com.ee.fb.domain.PersistentObject;
import com.ee.fb.domain.product.Product;

/**
 * 
 * @author ilya Единица товара из накладной
 */
public class InvoiceProductItem extends PersistentObject {

	/**
	 * Товар
	 */
	protected Product product;
	/**
	 * Единица измерения, код по ОКЕИ
	 */
	protected int measureOkeiCode;
	/**
	 * Вид упаковки
	 */
	protected int packageKind;
	/**
	 * Количество товара
	 */
	protected long count;
	/**
	 * Масса нетто
	 */
	protected double grossMass;

	/**
	 * Стоимость
	 */
	protected double price;
	/**
	 * Валюта
	 */
	protected int currency;

	/**
	 * Стоимость без НДС
	 */
	protected double priceWithoutNDS;

	/**
	 * Ставка НДС
	 */
	protected double nDSRate;

	/**
	 * Сумма НДС
	 */
	protected double priceWithNDS;

	public InvoiceProductItem(String id, Product product, int measureOkeiCode,
			int packageKind, long count, double grossMass, double price,
			int currency, double priceWithoutNDS, double nDSRate,
			double priceWithNDS) {
		super(id);
		this.product = product;
		this.measureOkeiCode = measureOkeiCode;
		this.packageKind = packageKind;
		this.count = count;
		this.grossMass = grossMass;
		this.price = price;
		this.currency = currency;
		this.priceWithoutNDS = priceWithoutNDS;
		this.nDSRate = nDSRate;
		this.priceWithNDS = priceWithNDS;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public int getMeasureOkeiCode() {
		return measureOkeiCode;
	}

	public void setMeasureOkeiCode(int measureOkeiCode) {
		this.measureOkeiCode = measureOkeiCode;
	}

	public int getPackageKind() {
		return packageKind;
	}

	public void setPackageKind(int packageKind) {
		this.packageKind = packageKind;
	}

	public long getCount() {
		return count;
	}

	public void setCount(long count) {
		this.count = count;
	}

	public double getGrossMass() {
		return grossMass;
	}

	public void setGrossMass(double grossMass) {
		this.grossMass = grossMass;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public int getCurrency() {
		return currency;
	}

	public void setCurrency(int currency) {
		this.currency = currency;
	}

	public double getPriceWithoutNDS() {
		return priceWithoutNDS;
	}

	public void setPriceWithoutNDS(double priceWithoutNDS) {
		this.priceWithoutNDS = priceWithoutNDS;
	}

	public double getNDSRate() {
		return nDSRate;
	}

	public void setNDSRate(double nDSRate) {
		this.nDSRate = nDSRate;
	}

	public double getPriceWithNDS() {
		return priceWithNDS;
	}

	public void setPriceWithNDS(double priceWithNDS) {
		this.priceWithNDS = priceWithNDS;
	}
}
