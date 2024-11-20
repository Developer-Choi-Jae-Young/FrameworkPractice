package com.kh.khEmail.controller;

import java.util.Map;
import java.util.Properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kh.khEmail.dto.AuthCodeDto;
import com.kh.khEmail.service.MailService;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@CrossOrigin(origins="http://localhost:3000")
@RestController
@RequiredArgsConstructor
@Slf4j
public class MailController {
	// 이메일 정보를 전달 받는 메소드
	// => 중요한 정보의 경우 POST를 자주 사용	
	private final MailService mailService;
	/*
	@PostMapping("/mail")
	public String sendMail(String email) {
		log.info("* email : {}", email);
		
		try {
			mailService.sendCode(email);			
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		return "ok";
	}
	*/
	
	
	@PostMapping("/mail")
	public String sendMail(@RequestBody Map<String, Object> request) throws Exception {
		String email = (String)request.get("email");
		
		if(email == null) {
			throw new Exception("필수 항목이 없습니다. (email)");
		}
		
		log.info("* email : {}", email);
		
		try {
			mailService.sendCode(email);			
		} catch (MessagingException e) {
			e.printStackTrace();
		}
		
		return "ok";
	}
	
	
	@PostMapping("/check")
//	public String authCode(String email, String code) {
	public String authCode(@RequestBody AuthCodeDto authCodeDto) throws Exception {
		String email = authCodeDto.getEmail();
		String code = authCodeDto.getCode();
		
		log.info("* email : {}", email);
		log.info("* code : {}", code);
		
		if(email == null || code == null) {
			throw new Exception("email 또는 code의 값이 null 입니다.");
		}
		
		if(mailService.checkAuthCode(email, code)) {
			return "success";
		} else {
			return "failed";
		}
	}
}
