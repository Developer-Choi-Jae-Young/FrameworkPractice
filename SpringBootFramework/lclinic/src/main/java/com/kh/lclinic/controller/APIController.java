package com.kh.lclinic.controller;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.net.HttpURLConnection;
import java.net.URL;

import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.lclinic.model.vo.User;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class APIController {
	
	// @Value : 외부 속성 주입 시 사용하는 어노테이션
	@Value("${google.client-id}")
	private String clientId;
	
	@Value("${google.redirect-uri}")
	private String redirectUri;
	
	@Value("${google.client-auth-passwd}")
	private String clientAuthPasswd;
	
	
	@RequestMapping("/login/oauth/google")
	public String googleLoginCallback(@RequestParam(value="error", defaultValue="") String error
									, @RequestParam(value="code", defaultValue="") String code
									, @RequestParam(value="scope", defaultValue="") String scope
									, HttpServletRequest request 
									, HttpSession session) throws Exception {
		log.info("---------------------------------------------");
		log.info("error : {}", error);
		log.info("code : {}", code);
		log.info("scope : {}", scope);
		
		log.info("request: {}", request.getRequestURI());
		log.info("---------------------------------------------");
		
	    if (code == null || code.isEmpty()) {
	        return "redirect:/";  // code가 없으면 홈으로 리다이렉트
	    }

	    // 인증 코드를 사용하여 액세스 토큰 요청
	    String tokenEndpoint = "https://oauth2.googleapis.com/token";
	    
	    // POST 요청 파라미터 설정
	    String params = "code=" + code
	            + "&client_id=" + clientId
	            + "&client_secret=" + clientAuthPasswd
	            + "&redirect_uri=" + redirectUri
	            + "&grant_type=authorization_code";

	    URL tokenUrl = new URL(tokenEndpoint);
	    HttpURLConnection tokenConn = (HttpURLConnection) tokenUrl.openConnection();
	    tokenConn.setRequestMethod("POST");
	    tokenConn.setDoOutput(true);

	    // 요청 파라미터 전송
	    try (OutputStream os = tokenConn.getOutputStream()) {
	        byte[] input = params.getBytes("utf-8");
	        os.write(input, 0, input.length);
	    }

	    // 응답 읽기
	    BufferedReader tokenBuf = new BufferedReader(new InputStreamReader(tokenConn.getInputStream(), "utf-8"));
	    String tokenLine;
	    StringBuilder tokenResponse = new StringBuilder();
	    while ((tokenLine = tokenBuf.readLine()) != null) {
	        tokenResponse.append(tokenLine.trim());
	    }
	    tokenBuf.close();
	    
	    /*
	    log.info("response data ====================");
	    log.info(tokenResponse.toString());
	    log.info("----------------------------------");
	    
	    */
	    // 액세스 토큰 데이터 추출  
	    JSONObject jsonResponse = stringToJsonObj(tokenResponse.toString());
	    
	    String accessToken = jsonResponse.get("access_token").toString();

	    // ---------------------------------------------------------------------------
	    // 액세스 토큰을 사용하여 인증된 사용자 정보 요청
	    URL requestUrl = new URL("https://www.googleapis.com/oauth2/v1/userinfo?access_token=" + accessToken);
	    HttpURLConnection conn = (HttpURLConnection) requestUrl.openConnection();
	    conn.setRequestMethod("GET");

	    // 사용자 정보 추출
	    BufferedReader userBuf = new BufferedReader(new InputStreamReader(conn.getInputStream(), "utf-8"));
	    String userLine;
	    StringBuilder userResponse = new StringBuilder();
	    while ((userLine = userBuf.readLine()) != null) {
	        userResponse.append(userLine.trim());
	    }
	    userBuf.close();
	    conn.disconnect();

	    // log.info(userResponse.toString());
	    
	    JSONObject userObj = stringToJsonObj(userResponse.toString());
	    User user = new User();
	    // sample=> {"id": "..","email": "..","verified_email": true,"name": "..","given_name": "..","family_name": "..","picture": ".."}
	    user.setId(userObj.get("email").toString());

	    // 세션에 사용자 정보 저장 (필요에 따라 수정 가능)
	    session.setAttribute("user", user);

	    return "redirect:/";  // 홈 또는 원하는 페이지로 리다이렉트
	}

	/**
	 * 문자열(json 형태)을 JSON객체로 변환
	 * @param data	json 형태의 문자열 데이터
	 * @return 전달받은 데이터를 기준으로 변환된 JSONObject 데이터
	 * @throws ParseException
	 * @throws org.json.simple.parser.ParseException 
	 */
	private JSONObject stringToJsonObj(String data) throws ParseException {
		JSONParser parser = new JSONParser();
	    return (JSONObject)parser.parse(data);
	}
}
