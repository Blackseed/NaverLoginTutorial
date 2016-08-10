package com.naver.naverlogintutorial.model;

import java.util.Date;

import org.apache.commons.lang.builder.ToStringBuilder;

import com.naver.naverlogintutorial.oauth.model.NaverUser;

public class SnsUser extends User {

	
	@SuppressWarnings("unused")
	private SnsUser(){}
	
	public SnsUser(String userName, String password, String email, String nickName, String mobile) {
		super(userName, password, email, nickName, mobile);
	}

	public SnsUser(String userName, NaverUser naverUser){
		super(userName, null, naverUser.getEmail(), naverUser.getNickname(), null);
		this.snsId = naverUser.getId();
		this.snsType = "NAVER";
		this.snsName = naverUser.getName();
		this.snsProfile = naverUser.getProfileImage();
	}
	
	private String snsId;
	private String snsType;
	private String snsName;
	private String snsProfile;
	private Date snsConnectDate;

	
	
	public User getUser(){
		return this;
	}
	
	public String getSnsId() {
		return snsId;
	}

	public String getSnsType() {
		return snsType;
	}

	public String getSnsName() {
		return snsName;
	}

	public String getSnsProfile() {
		return snsProfile;
	}

	public Date getSnsConnectDate() {
		return snsConnectDate;
	}

	public void setSnsId(String snsId) {
		this.snsId = snsId;
	}

	public void setSnsType(String snsType) {
		this.snsType = snsType;
	}

	public void setSnsName(String snsName) {
		this.snsName = snsName;
	}

	public void setSnsProfile(String snsProfile) {
		this.snsProfile = snsProfile;
	}

	public void setSnsConnectDate(Date snsConnectDate) {
		this.snsConnectDate = snsConnectDate;
	}
	
	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}
}
