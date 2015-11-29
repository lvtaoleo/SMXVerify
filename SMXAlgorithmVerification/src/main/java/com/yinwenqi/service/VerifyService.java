package com.yinwenqi.service;

import com.yinwenqi.model.LoginRsp;
import com.yinwenqi.model.UserInfo;

public interface VerifyService {

	LoginRsp verify(UserInfo userInfo);

	String getLastLoginTime(String userName);
}
