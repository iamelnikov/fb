package com.ee.fb.domain.invoice.impl;

import java.util.Collection;
import java.util.Date;

import com.ee.fb.domain.PersistentObject;
import com.ee.fb.domain.company.Company;
import com.ee.fb.domain.company.Consumer;
import com.ee.fb.domain.invoice.Invoice;
import com.ee.fb.domain.invoice.InvoiceProducerInfo;
import com.ee.fb.domain.invoice.InvoiceShipperInfo;
import com.ee.fb.domain.product.ProductCatalogItem;

/**
 * Товарная накладная 
 * 
 */

public class DefaultInvoiceImpl extends PersistentObject implements Invoice{

	/**
	 *  Дата составления
	 */
	protected Date dateOfPreparation;
	/**
	 * Номер накладной
	 */
	protected String number;
	/**
	 * Грузоотправитель
	 */
	protected InvoiceShipperInfo shipperInfo;
	/**
	 * Поставщик 
	 */
	protected InvoiceProducerInfo producerInfo;
	/**
	 * Плательщик
	 */
	protected Company payer;
	/**
	 * Грузополучатель
	 */
	protected Company consignee;
	
	/**
	 * Номер товарной накладной
	 */
	protected String billOfLadingNumber;
	
	protected Collection<ProductCatalogItem> items;

	public DefaultInvoiceImpl(String id, Date date, String number, InvoiceProducerInfo producerInfo,
			Consumer consumer, Collection<ProductCatalogItem> items) {
		super(id);
		this.number = number;
		this.producerInfo = producerInfo;
		this.items = items;
	}

	@Override
	public Date getDateOfPreparation() {
		return this.dateOfPreparation;
	}

	@Override
	public String getNumber() {
		return this.number;
	}

	@Override
	public InvoiceShipperInfo getInvoiceShipperInfo() {
		return shipperInfo;
	}

	@Override
	public Company getConsignment() {
		return this.consignee;
	}

	@Override
	public String getBillOfLading() {
		return billOfLadingNumber;
	}

	@Override
	public Company getPayer() {
		return payer;
	}
}
