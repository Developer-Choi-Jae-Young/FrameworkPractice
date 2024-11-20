package com.kh.khEmail.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import jakarta.mail.MessagingException;
import jakarta.mail.internet.MimeMessage;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MailService {
	private final JavaMailSender sender;
	
	private Map<String, String> authInfo = new HashMap<String, String>();
	
	public void sendMail(String subject, String text, String[] to) {
		SimpleMailMessage message = new SimpleMailMessage();
		
		message.setSubject(subject);
		message.setText(text);
		message.setTo(to);
	
		sender.send(message);
	}
	
	public void sendHTMLMail(String subject, String text, String[] to) throws MessagingException {
		MimeMessage mm = sender.createMimeMessage();
		MimeMessageHelper helper = new MimeMessageHelper(mm, true, "UTF-8");
		
		helper.setSubject(subject);
		helper.setText(text, true);
		helper.setTo(to);
		
		sender.send(mm);
	}
	
	public boolean checkAuthCode(String email, String code) {
		if(authInfo.get(email) != null && authInfo.get(email).equals(code)) {
			authInfo.remove(email);
			return true;
		} else {
			return false;
		}
	}
	
	public void sendCode(String email) throws MessagingException{
		String code = makeRandomCode("");
		
		String subject = "[KH] 인증코드";
		//String text = "인증코드 : " + code;
		String text = "<p> 아래의 인증코드를 입력해주세요. </p>"
						+ "<h3>" + code + "</h3>"
						+ "<p>인증 코드는 3분간 유효합니다.</p>";
		String[] to = {email};
				
		//sendMail(subject, text, to);
		sendHTMLMail(subject, text, to);
		authInfo.put(email, code);
	}
	
	private String makeRandomCode(String code) {
		if(code.length() == 6) {
			return code;
		} else {
			int value = (int)(Math.random() * 10);
			
			if(value % 2 == 0) {
				int ran = (int)(Math.random() * ('z' - 'a' + 1) + 'a');
				code += (char)ran;
			} else {
				code += value;
			}
			
			return makeRandomCode(code);
		}
	}
}
