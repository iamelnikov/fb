package com.ee.fb.domain.invoice.impl;

import java.util.Collection;
import java.util.Date;
import java.util.function.Consumer;

import com.ee.domain.company.AbstractCompany;
import com.ee.domain.company.Company;
import com.ee.domain.invoice.Invoice;
import com.ee.domain.invoice.InvoiceProducerInfo;
import com.ee.domain.invoice.InvoiceShipperInfo;
import com.ee.domain.mongo.document.DefaultMongoDocument;
import com.ee.domain.product.ProductCatalogItemImpl;
import com.mongodb.gridfs.GridFSDBFile;

/**
 * Товарная накладная 
 * 
 */

public class DefaultInvoiceImpl extends DefaultMongoDocument implements Invoice<GridFSDBFile>{

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
	protected AbstractCompany consignee;
	
	/**
	 * Номер товарной накладной
	 */
	protected String billOfLadingNumber;
	
	protected Collection<ProductCatalogItemImpl> items;

	public DefaultInvoiceImpl(String id, Date date, String number, InvoiceProducerInfo producerInfo,
			Consumer<?> consumer, Collection<ProductCatalogItemImpl> items) {
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
	public AbstractCompany getConsignment() {
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
