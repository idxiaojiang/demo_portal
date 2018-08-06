package com.portal.login.entity;

/**
 * 当前session存储信息的对象
 * @author Administrator
 *
 */
public class CurrentSessionDetail {
	private String ip;
	private int LoginFailureNum;
	private String currUserName;
	private int currAccount;
	private String verifyCode;
	
	private UserInfoDetailVO userInfoDetailVO;
	
	public CurrentSessionDetail(){
		setLoginFailureNum(0);
	}
	
	public String getVerifyCode() {
		return verifyCode;
	}
	public void setVerifyCode(String verifyCode) {
		this.verifyCode = verifyCode;
	}
	public UserInfoDetailVO getUserInfoDetailVO() {
		return userInfoDetailVO;
	}
	public void setUserInfoDetailVO(UserInfoDetailVO userInfoDetailVO) {
		this.userInfoDetailVO = userInfoDetailVO;
	}
	public String getIp() {
		return ip;
	}
	public void setIp(String ip) {
		this.ip = ip;
	}
	public int getLoginFailureNum() {
		return LoginFailureNum;
	}
	public void setLoginFailureNum(int loginFailureNum) {
		LoginFailureNum = loginFailureNum;
	}
	public String getCurrUserName() {
		return currUserName;
	}
	public void setCurrUserName(String currUserName) {
		this.currUserName = currUserName;
	}
	public int getCurrAccount() {
		return currAccount;
	}
	public void setCurrAccount(int currAccount) {
		this.currAccount = currAccount;
	}
	
	
}
