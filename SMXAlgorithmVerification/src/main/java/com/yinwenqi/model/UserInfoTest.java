
package com.yinwenqi.model;

public class UserInfoTest {

	private String userName;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("UserInfoTest [userName=");
		builder.append(userName);
		builder.append("]");
		return builder.toString();
	}

}
