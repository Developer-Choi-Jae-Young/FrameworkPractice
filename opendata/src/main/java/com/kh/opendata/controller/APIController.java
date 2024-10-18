package com.kh.opendata.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLEncoder;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class APIController {
	// 서비스 키
	private final String SERVICE_KEY = "%2BHTKlE8bXEiVMWJa7Gv0FDW9ehnd5Y5dmKAn%2FD7bS4e73GLqA%2B1peu8ZH8%2BSTJauVATa8C%2FDH0iJp%2B%2FixEeUdA%3D%3D";
	
	@ResponseBody
	@RequestMapping(value="/air.do", produces="application/json;charset=UTF-8")
	public String airPollution(String location, int pageNo) throws IOException {
		String url = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty"
					+ "?serviceKey=" + SERVICE_KEY 
					+ "&returnType=" + "JSON" 
					+ "&sidoName=" + URLEncoder.encode(location, "UTF-8")
					+ "&pageNo=" + URLEncoder.encode(String.valueOf(pageNo), "UTF-8");
		
		URL reqUrl = new URL(url);
		HttpURLConnection urlConn = (HttpURLConnection)reqUrl.openConnection();
		urlConn.setRequestMethod("GET");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
		
		String resText = "";
		String line;
		while((line = br.readLine()) != null) {
			resText += line;
		}
		
		br.close();
		urlConn.disconnect();
		
		return resText;
	}
	
	@ResponseBody
	@RequestMapping(value="/air2.do", produces="text/xml;charset=UTF-8")
	public String air2Do(String location, int pageNo) throws IOException {
		String url = "http://apis.data.go.kr/B552584/ArpltnInforInqireSvc/getCtprvnRltmMesureDnsty"
					+ "?serviceKey=" + SERVICE_KEY 
					+ "&sidoName=" + URLEncoder.encode(location, "UTF-8")
					+ "&pageNo=" + URLEncoder.encode(String.valueOf(pageNo), "UTF-8");
		
		URL reqUrl = new URL(url);
		HttpURLConnection urlConn = (HttpURLConnection)reqUrl.openConnection();
		urlConn.setRequestMethod("GET");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));

		String resText = "";
		String line;
		while((line = br.readLine()) != null) {
			resText += line;
		}
		
		br.close();
		urlConn.disconnect();
		
		return resText;
	}
	
	@ResponseBody
	@RequestMapping(value="/shelter.do", produces="application/json;charset=UTF-8")
	public String shelter(int pageNo, int numOfRows) throws IOException {
		String url = "http://apis.data.go.kr/1741000/TsunamiShelter4/getTsunamiShelter4List"
					+ "?ServiceKey=" + SERVICE_KEY 
					+ "&type=" + "JSON" 
					+ "&numOfRows=" + URLEncoder.encode(String.valueOf(numOfRows), "UTF-8")
					+ "&pageNo=" + URLEncoder.encode(String.valueOf(pageNo), "UTF-8");
		
		URL reqUrl = new URL(url);
		HttpURLConnection urlConn = (HttpURLConnection)reqUrl.openConnection();
		urlConn.setRequestMethod("GET");
		
		BufferedReader br = new BufferedReader(new InputStreamReader(urlConn.getInputStream()));
		
		String resText = "";
		String line;
		while((line = br.readLine()) != null) {
			resText += line;
		}
		
		br.close();
		urlConn.disconnect();
		
		return resText;
	}
	
	@RequestMapping("airPollution")
	public String showAirPollution() {
		return "airPollution";
	}
	
	@RequestMapping("tsunamiShelter")
	public String showShelter() {
		return "tsunamiShelter";
	}
}
