package com.yinwenqi.model;

public class UserInfo {

	private String userName;

	private String password;

	private int rememberPwd;

	private String certStr;

	private String cryptMode;

	private String publicKey;

	public String getCertStr() {
		return certStr;
	}

	public String getCryptMode() {
		return cryptMode;
	}

	public String getPassword() {
		return password;
	}

	public String getPublicKey() {
		return publicKey;
	}

	public String getUserName() {
		return userName;
	}

	public void setCertStr(String certStr) {
		this.certStr = certStr;
	}

	public void setCryptMode(String cryptMode) {
		this.cryptMode = cryptMode;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public int getRememberPwd() {
		return rememberPwd;
	}

	public void setRememberPwd(int rememberPwd) {
		this.rememberPwd = rememberPwd;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserInfo [userName=");
		builder.append(userName);
		builder.append(", password=");
		builder.append(password);
		builder.append(", rememberPwd=");
		builder.append(rememberPwd);
		builder.append(", certStr=");
		builder.append(certStr);
		builder.append(", cryptMode=");
		builder.append(cryptMode);
		builder.append(", publicKey=");
		builder.append(publicKey);
		builder.append("]");
		return builder.toString();
	}

}
