package com.ee.fb.domain.agreement;

import com.mongodb.gridfs.GridFSDBFile;

public interface Agreement {
	
	
	public void setAgreementFile(GridFSDBFile file);
	public GridFSDBFile getAgreementFile();
}
