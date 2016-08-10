package com.naver.naverlogintutorial.captcha.bo;

public interface CaptchaBO {

	public String getCaptchaKey();
	public String getCaptchaImageUrl(String captchaKey);
	public boolean isValidCaptcha(String captchaKey, String captchaInput);

}
