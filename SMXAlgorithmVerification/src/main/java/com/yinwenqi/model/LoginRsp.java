
package com.yinwenqi.model;

public class LoginRsp {

	private boolean canLogin;

	private String resultMsg;

	private String lastLoginTime;

	public String getLastLoginTime() {
		return lastLoginTime;
	}

	public void setLastLoginTime(String lastLoginTime) {
		this.lastLoginTime = lastLoginTime;
	}

	public boolean isCanLogin() {
		return canLogin;
	}

	public void setCanLogin(boolean canLogin) {
		this.canLogin = canLogin;
	}

	public String getResultMsg() {
		return resultMsg;
	}

	public void setResultMsg(String resultMsg) {
		this.resultMsg = resultMsg;
	}
}
