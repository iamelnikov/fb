package com.ee.fb.domain.agreement;

import java.util.Date;

import com.mongodb.gridfs.GridFSDBFile;

public interface Agreement {
	
	public String getCity();
	public String getNumber();
	public AgreementProducerInfo getProducerInfo();
	public AgreementConsumerInfo getConsumerInfo();
	public Date getSignDate();
	public Date getStartDate();
	public Date getEndDate();
	public double getSum();
	public int getCurrency();
	
	public AgreementTerms getAgreementTerms();
	
	public int getState();
	public void activate();
	public void close();
		
	public void setFile(GridFSDBFile file);
	public GridFSDBFile getFile();
}
