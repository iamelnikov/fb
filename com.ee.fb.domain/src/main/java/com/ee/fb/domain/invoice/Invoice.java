package com.ee.fb.domain.invoice;

import java.util.Date;

import org.springframework.data.mongodb.core.mapping.Document;

import com.ee.fb.domain.company.Company;

@Document(collection = "INVOICE")
public interface Invoice {
	
	public Date getDateOfPreparation();
	public String getNumber();
	
	public InvoiceShipperInfo getInvoiceShipperInfo();
	
	public Company getConsignment();
	public Company getPayer();
	public String getBillOfLading();
	
}
