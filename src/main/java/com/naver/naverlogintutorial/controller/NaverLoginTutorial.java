package com.naver.naverlogintutorial.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.github.scribejava.core.model.OAuth2AccessToken;
import com.naver.naverlogintutorial.bo.UserBO;
import com.naver.naverlogintutorial.captcha.bo.CaptchaBO;
import com.naver.naverlogintutorial.model.CommonErrorCode;
import com.naver.naverlogintutorial.model.SnsUser;
import com.naver.naverlogintutorial.model.User;
import com.naver.naverlogintutorial.oauth.bo.NaverLoginBO;
import com.naver.naverlogintutorial.oauth.model.NaverUser;
import com.naver.naverlogintutorial.utils.SecureUtils;



@Controller
public class NaverLoginTutorial {
	
	@Autowired
	private NaverLoginBO naverLoginBO;
	
	@Autowired
	private UserBO userBO;
	
	@Autowired
	private CaptchaBO captchaBO;

    @RequestMapping("/main")
    public ModelAndView main(HttpSession session) {
    	SnsUser snsUser = userBO.getSnsUserSession(session);
    	User user = userBO.getUserSession(session);
    	if( snsUser != null ){
    		Map<String,Object> paramMap = new HashMap<String,Object>();
            paramMap.put("user",snsUser);
    		return new ModelAndView("account", paramMap);
    	} else if(user != null){
    		Map<String,Object> paramMap = new HashMap<String,Object>();
            paramMap.put("user",user);
    		return new ModelAndView("account", paramMap);
    	} else {
    		return new ModelAndView("main");
    	}
    }
	
    @RequestMapping("/login")
    public ModelAndView login(HttpSession session) {
        String naverAuthorizeUrl = naverLoginBO.getAuthorizationUrl(session);
      
        Map<String,Object> paramMap = new HashMap<String,Object>();
        paramMap.put("url",naverAuthorizeUrl);
        
        return new ModelAndView("login", paramMap);
    }
    
    @RequestMapping("/join")
    public ModelAndView join(HttpSession session) {
    	String naverAuthorizeUrl = naverLoginBO.getAuthorizationUrl(session);
    	
    	Map<String,Object> paramMap = new HashMap<String,Object>();
    	paramMap.put("url",naverAuthorizeUrl);
    	
    	return new ModelAndView("join", paramMap);
    }
    
    @RequestMapping("/join/confirm")
    public ModelAndView joinConfirm(HttpServletRequest request, HttpSession session) {
    	
    	String userName = request.getParameter("username");
    	String password = request.getParameter("password");
    	String email = request.getParameter("email");
    	String nickName = request.getParameter("nickname");
    	String mobile = request.getParameter("mobile");
   	
    	User user = new User(userName,password,email,nickName,mobile);
    	
    	String captchaKey = captchaBO.getCaptchaKey();
    	String captchaImageUrl = captchaBO.getCaptchaImageUrl(captchaKey);
    	Map<String,Object> paramMap = new HashMap<String,Object>();
    	paramMap.put("captchaKey", captchaKey);
    	paramMap.put("captchaImageUrl", captchaImageUrl);
    	paramMap.put("user", user);
    	
    	userBO.setJoinUserSession(session, user);
    	
    	return new ModelAndView("join_confirm", paramMap);
    }
    
    
    @RequestMapping("/join/done")
    public ModelAndView joinDone(HttpServletRequest request, HttpSession session) {
    	
    	String captchaInput = request.getParameter("captchaInput");
    	String captchaKey = request.getParameter("captchaKey");
    	
    	User user = userBO.getJoinUserSession(session);
    	
    	if(captchaBO.isValidCaptcha(captchaKey, captchaInput)){
    		
    		User newUser = userBO.createNewUserByUser(user);
    		userBO.initSession(session);
    		userBO.setUserSession(session, newUser);
    		return new ModelAndView("redirect:/account");
    		    		
    	} else {
    		captchaKey = captchaBO.getCaptchaKey();
        	String captchaImageUrl = captchaBO.getCaptchaImageUrl(captchaKey);
        	Map<String,Object> paramMap = new HashMap<String,Object>();
        	paramMap.put("captchaKey", captchaKey);
        	paramMap.put("captchaImageUrl", captchaImageUrl);
        	paramMap.put("user", user);
        	paramMap.put("errorMessage", CommonErrorCode.INVALID_CAPTCHA.getErrorText());
        	
    		return new ModelAndView("join_confirm", paramMap);
    	}
    }
    
    
//    @RequestMapping("/join/sns/done")
//    public ModelAndView joinSnsDone(HttpServletRequest request, HttpSession session) {
//    	
//    	String captchaInput = request.getParameter("captchaInput");
//    	String captchaKey = request.getParameter("captchaKey");
//    	String username = request.getParameter("username");
//    	
//    	NaverUser naverUser = userBO.getNaverUserSession(session);
//    	
//    	if(captchaBO.isValidCaptcha(captchaKey, captchaInput)){
//    		
//    		SnsUser newUser = userBO.createNewUserBySnsUser(naverUser, username);
//    		userBO.initSession(session);
//    		userBO.setSnsUserSession(session, newUser);
//    		return new ModelAndView("redirect:/account");
//    		
//    	} else {
//    		captchaKey = captchaBO.getCaptchaKey();
//    		String captchaImageUrl = captchaBO.getCaptchaImageUrl(captchaKey);
//    		Map<String,Object> paramMap = new HashMap<String,Object>();
//    		paramMap.put("captchaKey", captchaKey);
//    		paramMap.put("captchaImageUrl", captchaImageUrl);
//    		paramMap.put("user", naverUser);
//    		paramMap.put("suggestUserName", username);
//    		paramMap.put("errorMessage", CommonErrorCode.INVALID_CAPTCHA.getErrorText());
//    		
//    		return new ModelAndView("join_sns_confirm", paramMap);
//    	}
//    }
    
    
    
    @RequestMapping("/login/submit")
    public ModelAndView doLogin(HttpServletRequest request, HttpSession session) {
    
    	String userName = request.getParameter("username");
    	String password = request.getParameter("password");
 
    	User user = userBO.getUserByUserName(userName);
    	if( user != null &&  user.isValidPassword(password) ){
    		session.setAttribute("USER",user);
    		return new ModelAndView("redirect:/account");
    	} else {
    		String naverAuthorizeUrl = naverLoginBO.getAuthorizationUrl(session);
            Map<String,Object> paramMap = new HashMap<String,Object>();
            paramMap.put("url",naverAuthorizeUrl);
            paramMap.put("errorMessage","아이디 또는 비밀번호가 올바르지 않습니다.");
            return new ModelAndView("login", paramMap);
    	}
    }
    
    
//    @RequestMapping("/callback")
//    public ModelAndView callback(@RequestParam String code, @RequestParam String state, HttpSession session) throws IOException {
//    	OAuth2AccessToken oauthToken = naverLoginBO.getAccessToken(session, code, state);
//        NaverUser naverUser = naverLoginBO.getUserProfile(oauthToken);
//        
//        SnsUser snsUser = userBO.getUserByNaverUser(naverUser);
//        
//        /* 네이버 아이디로 로그인을 통해 등록된적이 없는 사용자의 경우 신규 등록으로 처리 */
//        if(snsUser == null){
//        	 /*  네이버 프로필을 세션에 저장하고 추가정보를 받는 페이지로 이동 */
//        	userBO.setNaverUserSession(session, naverUser);
//        	String captchaKey = captchaBO.getCaptchaKey();
//        	String captchaImageUrl = captchaBO.getCaptchaImageUrl(captchaKey);
//        	Map<String,Object> paramMap = new HashMap<String,Object>();
//        	paramMap.put("captchaKey", captchaKey);
//        	paramMap.put("captchaImageUrl", captchaImageUrl);
//        	paramMap.put("user", naverUser);
//        	paramMap.put("suggestUserName", userBO.getSuggestUserNameFromEmail(naverUser.getEmail()));
//        	
//        	return new ModelAndView("join_sns_confirm", paramMap);
//        	
//        	
//        }      	 
//        	
//        userBO.setSnsUserSession(session, snsUser);
//        return new ModelAndView("redirect:/account");
//    }
    
    @RequestMapping("/account")
    public ModelAndView account(HttpSession session){
    	SnsUser snsUser = userBO.getSnsUserSession(session);
    	User user = userBO.getUserSession(session);
    	if( snsUser != null ){
    		Map<String,Object> paramMap = new HashMap<String,Object>();
            paramMap.put("user",snsUser);
    		return new ModelAndView("account", paramMap);
    	} else if(user != null){
    		Map<String,Object> paramMap = new HashMap<String,Object>();
            paramMap.put("user",user);
    		return new ModelAndView("account", paramMap);
    	} else {
    		// REDIRECT TO LOGIN
    		return new ModelAndView("redirect:/login");
    	}
    }

    @RequestMapping("/logout")
    public ModelAndView logout(HttpSession session){
    	userBO.initSession(session);
    	return new ModelAndView("redirect:/main");
    }

    
}
