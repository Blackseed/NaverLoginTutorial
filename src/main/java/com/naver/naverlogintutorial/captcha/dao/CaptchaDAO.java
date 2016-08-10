package com.naver.naverlogintutorial.captcha.dao;

import java.io.IOException;
import java.net.URISyntaxException;

public interface CaptchaDAO {

	public String getCaptchaKey() throws IOException;
	public String getCaptchaImageUrl(String captchaKey);
	public boolean isValidCaptcha(String captchaKey, String captchaInput) throws URISyntaxException, IOException;
	
}
