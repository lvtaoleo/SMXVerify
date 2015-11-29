
package com.yinwenqi.service.impl;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.stereotype.Service;

import com.yinwenqi.db.DataBase;
import com.yinwenqi.model.LoginRsp;
import com.yinwenqi.model.UserInfo;
import com.yinwenqi.service.VerifyService;

@Service
public class VerifyServiceImpl implements VerifyService {

	@Override
	public LoginRsp verify(UserInfo userInfo) {
		LoginRsp loginRsp = new LoginRsp();
		if (userInfo.getUserName() == null || !userInfo.getUserName().equals(DataBase.userName)) {
			loginRsp.setCanLogin(false);
			loginRsp.setResultMsg("success_jsonpCallback([{result:\"false\",resultMsg:\"This user is not exists!\"}])");
		} else if (DataBase.pwdWrongTime >= 5) {
			loginRsp.setCanLogin(false);
			loginRsp.setResultMsg(
					"success_jsonpCallback([{result:\"false\",resultMsg:\"You have try too many times, the account has been locked\"}])");
		} else if (userInfo.getPassword() == null || !userInfo.getPassword().equals(DataBase.password)) {
			DataBase.pwdWrongTime++;
			loginRsp.setCanLogin(false);
			if ((5 - DataBase.pwdWrongTime) == 0) {
				loginRsp.setResultMsg(
						"success_jsonpCallback([{result:\"false\",resultMsg:\"Password wrong times is too much, the account has been locked\"}])");
			} else {
				loginRsp.setResultMsg("success_jsonpCallback([{result:\"false\",resultMsg:\"Password is wrong, "
						+ (5 - DataBase.pwdWrongTime) + " times remained\"}])");
			}
		} else {
			loginRsp.setCanLogin(true);
			loginRsp.setResultMsg("success_jsonpCallback([{result:\"true\",location:\"welcome\"}])");
			DataBase.pwdWrongTime = 0;
			DataBase.lastLoginTime = getLastLoginTime("yinwenqi");
			DataBase.cryptMode = userInfo.getCryptMode();
		}
		return loginRsp;
	}

	@Override
	public String getLastLoginTime(String userName) {
		return new SimpleDateFormat().format(new Date(System.currentTimeMillis()));
	}

}
