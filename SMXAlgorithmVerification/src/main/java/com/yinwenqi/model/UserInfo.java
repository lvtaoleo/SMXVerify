package com.yinwenqi.model;

public class UserInfo {
	
	private String userName;
	
	private String password;
	
	private boolean isRememberPwd;
	
	private String certStr;

	private int cryptMode;

	private String publicKey;

	public String getCertStr() {
		return certStr;
	}

	public int getCryptMode() {
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

	public boolean isRememberPwd() {
		return isRememberPwd;
	}

	public void setCertStr(String certStr) {
		this.certStr = certStr;
	}

	public void setCryptMode(int cryptMode) {
		this.cryptMode = cryptMode;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public void setPublicKey(String publicKey) {
		this.publicKey = publicKey;
	}

	public void setRememberPwd(boolean isRememberPwd) {
		this.isRememberPwd = isRememberPwd;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserInfo [userName=");
		builder.append(userName);
		builder.append(", password=");
		builder.append(password);
		builder.append(", publicKey=");
		builder.append(publicKey);
		builder.append(", certStr=");
		builder.append(certStr);
		builder.append(", cryptMode=");
		builder.append(cryptMode);
		builder.append(", isRememberPwd=");
		builder.append(isRememberPwd);
		builder.append("]");
		return builder.toString();
	}

}
