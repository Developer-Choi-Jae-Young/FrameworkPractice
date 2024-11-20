package com.kh.springboot.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class PracticeController {
	
	@GetMapping("/practice")
	public String practicePage(Model model, HttpSession session) {
		model.addAttribute("name", "최재영");
		model.addAttribute("title", "<h3>Hello, Thymeleaf~</h3>");
		
		session.setAttribute("age", 20);
		
		return "practice";
	}
	
	@GetMapping("/test")
	public String testPage() {
		return "main";
	}
}
