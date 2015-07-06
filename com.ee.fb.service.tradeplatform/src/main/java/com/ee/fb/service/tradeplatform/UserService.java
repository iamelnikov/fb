package com.ee.fb.service.tradeplatform;

import com.ee.fb.domain.user.User;

public interface UserService {
	public void saveUser(String userName, String password);
	public User findUser(String userName);
	
}
