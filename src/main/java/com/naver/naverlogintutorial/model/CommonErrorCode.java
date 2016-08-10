package com.naver.naverlogintutorial.model;

public enum CommonErrorCode {

	INVALID_LOGIN_PASSWORD("InvalidLoginPassword", "아이디 또는 비밀번호가 올바르지 않습니다." ),
	INVALID_CAPTCHA("InvalidCaptcha","자동가입방지문자의 입력이 올바르지 않습니다."),
	INVALID_LOGIN_USER("InvalidLoginUser","아이디 또는 비밀번호가 올바르지 않습니다.");
	
	private String code;
	private String errorText;
	private CommonErrorCode(String code, String errorText) {
		this.code = code;
		this.errorText = errorText;
	}

	public String getErrorText() {
		return errorText;
	}
	public static String getErrorText(String code) {
		CommonErrorCode[] values = CommonErrorCode.values();

		for (CommonErrorCode commonErrorCode : values) {
			if (commonErrorCode.getCode().equals(code)) {
				return commonErrorCode.errorText;
			}
		}
		return null;
	}
	public String getCode() {
		return code;
	}
	
	
	
}
