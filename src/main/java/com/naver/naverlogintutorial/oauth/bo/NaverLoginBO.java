package com.naver.naverlogintutorial.oauth.bo;

import java.io.IOException;
import java.util.UUID;

import javax.servlet.http.HttpSession;

import org.apache.commons.lang.StringUtils;
import org.codehaus.jackson.JsonParseException;
import org.codehaus.jackson.map.JsonMappingException;
import org.codehaus.jackson.map.ObjectMapper;

import com.github.scribejava.core.builder.ServiceBuilder;
import com.github.scribejava.core.model.OAuth2AccessToken;
import com.github.scribejava.core.model.OAuthRequest;
import com.github.scribejava.core.model.Response;
import com.github.scribejava.core.model.Verb;
import com.github.scribejava.core.oauth.OAuth20Service;
import com.naver.naverlogintutorial.oauth.model.NaverLoginApi;
import com.naver.naverlogintutorial.oauth.model.NaverProfileResponse;
import com.naver.naverlogintutorial.oauth.model.NaverUser;

public class NaverLoginBO {

	private final static String CLIENT_ID = "";
	private final static String CLIENT_SECRET = "";
	private final static String REDIRECT_URI = "http://127.0.0.1:8080/NaverLoginTutorial/callback";
	private final static String SESSION_STATE = "oauth_state";
	private final static String PROFILE_API_URL = "https://openapi.naver.com/v1/nid/me";

		
	public String getAuthorizationUrl(HttpSession session) {

		/* 세션 유효성 검증을 위하여 난수를 생성 */
		String state = generateRandomString();
		/* 생성한 난수 값을 session에 저장 */
		setSession(session, state);
		OAuth20Service oauthService = getOauthService(state);
		return oauthService.getAuthorizationUrl();
	}

	/* 네아로 Callback 처리 및  AccessToken 획득 Method */
	public OAuth2AccessToken getAccessToken(HttpSession session, String code, String state) throws IOException {

		/* Callback으로 전달받은 세선검증용 난수값과 세션에 저장되어있는 값이 일치하는지 확인 */
		String sessionState = getSession(session);
		if (StringUtils.equals(sessionState, state)) {
			OAuth20Service oauthService = getOauthService(state);
			/* Scribe에서 제공하는 AccessToken 획득 기능으로 네아로 Access Token을 획득 */
			OAuth2AccessToken accessToken = oauthService.getAccessToken(code);
			return accessToken;
		}
		return null;
	}

	public NaverUser getUserProfile(OAuth2AccessToken oauthToken) throws IOException{
		return getUserProfile(oauthToken, false);
	}
	public NaverUser getUserProfile(OAuth2AccessToken oauthToken, boolean isFinalRequest) throws IOException {

		Response response = sendProfileApiRequest(oauthToken);
		int responseCode = response.getCode();
		
		if(isSuccessResponse(responseCode)){
			return getNaverUser(response.getBody());
		}
		
		if( needRefresh(responseCode, isFinalRequest)){
			OAuth2AccessToken refreshedToken = refreshAccessToken(oauthToken);
			return getUserProfile(refreshedToken, true);
		}
		
		return null;
	}

	private Response sendProfileApiRequest(OAuth2AccessToken oauthToken){
		OAuth20Service oauthService = getOauthService();
		OAuthRequest request = new OAuthRequest(Verb.GET, PROFILE_API_URL, oauthService);
		oauthService.signRequest(oauthToken, request);
		Response response = request.send();
		return response;
	}
	
	private boolean isSuccessResponse(int responseCode){
		return ( responseCode == 200 );
	}
	private boolean needRefresh(int responseCode, boolean isFinalRequest){
		return ( responseCode == 401 && !isFinalRequest );
	}
	
	private String generateRandomString() {
		return UUID.randomUUID().toString();
	}

	private void setSession(HttpSession session, String state) {
		session.setAttribute(SESSION_STATE, state);
	}

	private String getSession(HttpSession session) {
		return (String)session.getAttribute(SESSION_STATE);
	}
	
	private OAuth20Service getOauthService(String state){
		ServiceBuilder sb  = new ServiceBuilder()
			.apiKey(CLIENT_ID)
			.apiSecret(CLIENT_SECRET)
			.callback(REDIRECT_URI);
		if( StringUtils.isNotEmpty(state)){
			sb = sb.state(state);
		}
		return sb.build(NaverLoginApi.instance());
	}
	
	private OAuth20Service getOauthService(){
		return getOauthService(null);
	}
	
	
	private OAuth2AccessToken refreshAccessToken( OAuth2AccessToken oauthToken) throws IOException{
		OAuth20Service oauthService = getOauthService();
		return oauthService.refreshAccessToken(oauthToken.getRefreshToken());
	}

	private NaverUser getNaverUser(String profileResponse) throws JsonParseException, JsonMappingException, IOException {
		ObjectMapper mapper = new ObjectMapper();
		NaverProfileResponse naverProfileResponse = null;

		naverProfileResponse = mapper.readValue(profileResponse, NaverProfileResponse.class);
		
		if (naverProfileResponse != null) {
			return naverProfileResponse.getResponse();
		}
		return null;
	}

}
