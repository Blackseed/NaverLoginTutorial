package com.naver.naverlogintutorial.dao;

import com.naver.naverlogintutorial.model.SnsUser;
import com.naver.naverlogintutorial.model.User;
import com.naver.naverlogintutorial.oauth.model.NaverUser;

public interface UserDAO {
	
	public User getUserById(int id);
	public User getUserByUserName(String userName);
	User getUserBySnsId(String snsId);
	User insertUser(User user);
	public SnsUser insertUser(NaverUser naverUser, String username);

}
