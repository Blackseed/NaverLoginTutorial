package com.naver.naverlogintutorial.oauth.model;

import org.apache.commons.lang.builder.ToStringBuilder;
import org.codehaus.jackson.annotate.JsonProperty;
import org.codehaus.jackson.map.annotate.JsonSerialize;

@JsonSerialize(include = JsonSerialize.Inclusion.NON_NULL)
public class NaverProfileResponse {

	@JsonProperty("resultcode")
	private String resultcode;
	@JsonProperty("message")
	private String message;
	@JsonProperty("response")
	private NaverUser response;

	@JsonProperty("resultcode")
	public String getResultcode() {
		return resultcode;
	}

	@JsonProperty("resultcode")
	public void setResultcode(String resultcode) {
		this.resultcode = resultcode;
	}

	@JsonProperty("message")
	public String getMessage() {
		return message;
	}

	@JsonProperty("message")
	public void setMessage(String message) {
		this.message = message;
	}
	
	@JsonProperty("response")
	public NaverUser getResponse() {
		return response;
	}
	
	@JsonProperty("response")
	public void setResponse(NaverUser response) {
		this.response = response;
	}

	@Override
	public String toString() {
		return ToStringBuilder.reflectionToString(this);
	}

}
