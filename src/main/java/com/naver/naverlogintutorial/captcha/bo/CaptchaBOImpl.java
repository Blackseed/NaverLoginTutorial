package com.naver.naverlogintutorial.captcha.bo;

import java.io.IOException;
import java.net.URISyntaxException;

import org.springframework.beans.factory.annotation.Autowired;

import com.naver.naverlogintutorial.captcha.dao.CaptchaDAO;

public class CaptchaBOImpl implements CaptchaBO{

	@Autowired
	private CaptchaDAO captchaDAO;
	
	@Override
	public String getCaptchaKey() {
		try {
			String captchaKey = captchaDAO.getCaptchaKey();
			return captchaKey;
		} catch (IOException e) {
				
		}
		return null;
	}

	@Override
	public String getCaptchaImageUrl(String captchaKey) {
		String captchaUrl = captchaDAO.getCaptchaImageUrl(captchaKey);
		return captchaUrl;
	}

	@Override
	public boolean isValidCaptcha(String captchaKey, String captchaInput) {
		
		try {
			boolean result = captchaDAO.isValidCaptcha(captchaKey, captchaInput);
			return result;
		} catch (URISyntaxException | IOException e) {
			return false;
		}
	}

}
