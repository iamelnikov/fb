package com.ee.fb.domain.invoice;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "INVOICE")
public interface Invoice {
	
	public Date getDateOfPreparation();
	public String getNumber;
	
	public InvoiceShipperInfo getInvoiceShipperInfo();
	
	public String getConsignment();
	public String getBillOfLading();
	
}
