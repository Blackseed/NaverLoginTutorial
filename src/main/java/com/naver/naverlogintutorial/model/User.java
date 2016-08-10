package com.naver.naverlogintutorial.model;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.springframework.util.StringUtils;

import com.naver.naverlogintutorial.utils.SecureUtils;

public class User {

	private int id;
	private String userName;
	private String password;
	private String email;
	private String nickName;
	private String mobile;
	private Date createDate;
	private Date modifyDate;
	private static final String DEFAULT_PASSPHRASE = "!@#!@#%^!(#$!@#asl1aoS9Va021@#";
	
	@SuppressWarnings("unused")
	protected User(){}
	
	public User(String userName, String password, String email, String nickName, String mobile) {
		super();
		this.userName = userName;
		if(StringUtils.isEmpty(password)){
			this.password = SecureUtils.getPasswordHash(DEFAULT_PASSPHRASE, DEFAULT_PASSPHRASE);
		} else {
			this.password = SecureUtils.getPasswordHash(password, userName);
		}
		this.email = email;
		this.nickName = nickName;
		this.mobile = mobile;
	}


	public int getId() {
		return id;
	}
	public String getUserName() {
		return userName;
	}
	public String getPassword() {
		return password;
	}
	public String getEmail() {
		return email;
	}
	public String getNickName() {
		return nickName;
	}
	public Date getCreateDate() {
		return createDate;
	}
	public Date getModifyDate() {
		return modifyDate;
	}
	public void setId(int id) {
		this.id = id;
	}
	public void setUserName(String userName) {
		this.userName = userName;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public void setNickName(String nickName) {
		this.nickName = nickName;
	}
	public void setCreateDate(Date createDate) {
		this.createDate = createDate;
	}
	public void setModifyDate(Date modifyDate) {
		this.modifyDate = modifyDate;
	}
	
	public boolean isValidPassword(String plainPassword){
		return SecureUtils.isMatchedPassword(plainPassword, this.userName, this.password);
	}
	
	public String getMobile() {
		return mobile;
	}
	public void setMobile(String mobile) {
		this.mobile = mobile;
	}
	
	@Override
	public String toString(){
		return ToStringBuilder.reflectionToString(this);
	}
	
}
