package com.ee.fb.domain.product;

import com.mongodb.gridfs.GridFSFile;

public interface Technology {

	public String getTechnologyDescription();
	public GridFSFile getFile(); 
}
