package com.kh.lclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;

import com.kh.lclinic.model.vo.User;
import com.kh.lclinic.service.UserSerivce;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class UserController {
	private final UserSerivce userSerivce;
	
	@PostMapping("/login")
	public String login(User user, HttpSession session) {
		System.out.println("ID : " + user.getId());
		System.out.println("PASSWORD : " + user.getPassword());
		
		//session.setAttribute("user", user);
		
		User loginUser = userSerivce.loginUser(user);
		
		if(loginUser != null) {
			session.setAttribute("user", loginUser);
		}
		
		return "redirect:/";
	}
}
