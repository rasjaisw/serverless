package com.cg.framework.cache;

import com.cg.framework.base.auth.AuthDTO;

public interface ApplicationServiceCache {

	void put(String tokenID, String authObj);
	
	void remove(String tokenID);

	boolean validate(String tokenID);

	AuthDTO get(String tokenID);

}