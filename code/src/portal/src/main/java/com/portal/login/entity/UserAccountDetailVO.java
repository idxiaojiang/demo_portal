package com.portal.login.entity;

import java.util.Date;

/**
 * 用户账号信息
 * @author Administrator
 *
 */
public class UserAccountDetailVO {
	private int account;
	private int userId;
	private String userName;
	private String userPassword;
	private Date registerDate;
	private String registerQQ;
	private String registerWX;
	private String registerWeibo;
	private String registerPhone;
	private String registerWay;
	private String registerMail;
	private Date createdDate;
	public int getAccount() {
		return account;
	}
	public void setAccount(int account) {
		this.account = account;
	}
	public int getUserId() {
		return userId;
	}
	public void setUserId(int userId) {
		this.userId = userId;
	}
	public String getUserName() {
		return userName;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public String getUserPassword() {
		return userPassword;
	}
	public void setUserPassword(String userPassword) {
		this.userPassword = userPassword;
	}
	public Date getRegisterDate() {
		return registerDate;
	}
	public void setRegisterDate(Date registerDate) {
		this.registerDate = registerDate;
	}
	public String getRegisterQQ() {
		return registerQQ;
	}
	public void setRegisterQQ(String registerQQ) {
		this.registerQQ = registerQQ;
	}
	public String getRegisterWX() {
		return registerWX;
	}
	public void setRegisterWX(String registerWX) {
		this.registerWX = registerWX;
	}
	public String getRegisterWeibo() {
		return registerWeibo;
	}
	public void setRegisterWeibo(String registerWeibo) {
		this.registerWeibo = registerWeibo;
	}
	public String getRegisterPhone() {
		return registerPhone;
	}
	public void setRegisterPhone(String registerPhone) {
		this.registerPhone = registerPhone;
	}
	public String getRegisterWay() {
		return registerWay;
	}
	public void setRegisterWay(String registerWay) {
		this.registerWay = registerWay;
	}
	public String getRegisterMail() {
		return registerMail;
	}
	public void setRegisterMail(String registerMail) {
		this.registerMail = registerMail;
	}
	public Date getCreatedDate() {
		return createdDate;
	}
	public void setCreatedDate(Date createdDate) {
		this.createdDate = createdDate;
	}
	
	
}
