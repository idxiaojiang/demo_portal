package com.portal.login.entity;

public class UserInfoDetailVO {
	private String username;
	private String password;
	private String account;
	private String verifyCode;
	private UserAccountDetailVO accountDetailVO;
	
	
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getVerifyCode() {
		return verifyCode;
	}
	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getAccount() {
		return account;
	}
	public void setAccount(String account) {
		this.account = account;
	}
	public UserAccountDetailVO getAccountDetailVO() {
		return accountDetailVO;
	}
	public void setAccountDetailVO(UserAccountDetailVO accountDetailVO) {
		this.accountDetailVO = accountDetailVO;
	}
	
	
	
}
