package com.naver.naverlogintutorial.bo;

import java.util.Random;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import com.naver.naverlogintutorial.dao.UserDAO;
import com.naver.naverlogintutorial.model.SnsUser;
import com.naver.naverlogintutorial.model.User;
import com.naver.naverlogintutorial.oauth.model.NaverUser;

public class UserBOImpl implements UserBO{

	private static final String USER_SESSION = "USER";
	private static final String SNS_USER_SESSION = "SNS_USER";
	private static final String JOIN_USER_SESSION = "JOIN_USER";
	private static final String NAVER_SESSION = "NAVER_USER";
	private static Random generator = new Random();
	
	@Autowired
	private UserDAO userDAO;
	
	@Override
	public User getUserByUserName(String userName) {
		return userDAO.getUserByUserName(userName);
	}
	
	@Override
	public void setUserSession(HttpSession session, User user){
		session.setAttribute(USER_SESSION, user);
	}
	
	
	@Override
	public User getUserSession(HttpSession session){
		User user = (User)session.getAttribute(USER_SESSION);
		return user;
	}
	
	@Override
	public void setJoinUserSession(HttpSession session, User user){
		session.setAttribute(JOIN_USER_SESSION, user);
	}
	
	
	@Override
	public User getJoinUserSession(HttpSession session){
		User user = (User)session.getAttribute(JOIN_USER_SESSION);
		return user;
	}
	
	
	@Override
	public void setSnsUserSession(HttpSession session, SnsUser snsUser){
		session.setAttribute(SNS_USER_SESSION, snsUser);
	}
	
	
	@Override
	public SnsUser getSnsUserSession(HttpSession session){
		SnsUser snsUser = (SnsUser)session.getAttribute(SNS_USER_SESSION);
		return snsUser;
	}
	
	@Override
	public void setNaverUserSession(HttpSession session, NaverUser naverUser){
		session.setAttribute(NAVER_SESSION, naverUser);
	}
	
	
	@Override
	public NaverUser getNaverUserSession(HttpSession session){
		NaverUser naverUser = (NaverUser)session.getAttribute(NAVER_SESSION);
		return naverUser;
	}
	
	@Override
	public void initSession(HttpSession session){
		session.setAttribute(NAVER_SESSION, null);
		session.setAttribute(USER_SESSION, null);
		session.setAttribute(JOIN_USER_SESSION, null);
		session.setAttribute(SNS_USER_SESSION , null);
	}

	@Override
	public SnsUser getUserByNaverUser(NaverUser naverUser) {
		if(naverUser != null){
			String snsId = naverUser.getId();
			return (SnsUser)userDAO.getUserBySnsId(snsId);
		}
		return null;
	}
	
	@Override
	public User createNewUserByUser(User user ) {
		User newUser = userDAO.insertUser(user);
		return newUser;
	}
	
	@Override
	public SnsUser createNewUserBySnsUser(NaverUser naverUser, String username) {
		SnsUser newUser = userDAO.insertUser(naverUser, username);
		return newUser;
	}
	
	
	@Override
	public String getSuggestUserNameFromEmail(String email) {
		String emailAccount = email.split("@")[0];
		
		String suggestUserName = isExistUserName(emailAccount);
		if( StringUtils.isEmpty(suggestUserName)){
			while(true) {
				StringBuilder sb = new StringBuilder(emailAccount);
				sb.append("_");
				sb.append(generator.nextInt(100));
				suggestUserName = isExistUserName(sb.toString());
				if( StringUtils.isNotEmpty(suggestUserName)){
					break;
				}
			}
		}
		return suggestUserName;
	}
	
	
	
	private String isExistUserName(String username){
		User user = userDAO.getUserByUserName(username);
		if( user != null ) {
			return null;
		}
		return username;
	}


	
	

}
