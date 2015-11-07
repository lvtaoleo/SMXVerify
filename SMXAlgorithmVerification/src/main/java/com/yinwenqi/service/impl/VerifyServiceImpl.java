package com.yinwenqi.service.impl;

import org.springframework.stereotype.Service;

import com.yinwenqi.model.UserInfo;
import com.yinwenqi.service.VerifyService;

@Service
public class VerifyServiceImpl implements VerifyService {

	@Override
	public boolean verify(UserInfo userInfo) {
		return true;
	}

	@Override
	public String getLastLoginTime(String userName) {
		return null;
	}

}
