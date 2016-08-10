package com.naver.naverlogintutorial.bo;

import javax.servlet.http.HttpSession;

import com.naver.naverlogintutorial.model.SnsUser;
import com.naver.naverlogintutorial.model.User;
import com.naver.naverlogintutorial.oauth.model.NaverUser;

public interface UserBO {

	public User getUserByUserName(String userName);
	
	public SnsUser getUserByNaverUser(NaverUser naverUser);

	void setUserSession(HttpSession session, User user);

	User getUserSession(HttpSession session);

	User createNewUserByUser(User user);

	void setNaverUserSession(HttpSession session, NaverUser naverUser);

	NaverUser getNaverUserSession(HttpSession session);

	void setSnsUserSession(HttpSession session, SnsUser user);

	SnsUser getSnsUserSession(HttpSession session);

	String getSuggestUserNameFromEmail(String email);

	User getJoinUserSession(HttpSession session);

	void setJoinUserSession(HttpSession session, User user);

	void initSession(HttpSession session);

	public SnsUser createNewUserBySnsUser(NaverUser naverUser, String username);
}
