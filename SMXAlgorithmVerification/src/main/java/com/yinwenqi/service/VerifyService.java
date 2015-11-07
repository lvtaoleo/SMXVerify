package com.yinwenqi.service;

import com.yinwenqi.model.UserInfo;

public interface VerifyService {
	boolean verify(UserInfo userInfo);

	String getLastLoginTime(String userName);
}
