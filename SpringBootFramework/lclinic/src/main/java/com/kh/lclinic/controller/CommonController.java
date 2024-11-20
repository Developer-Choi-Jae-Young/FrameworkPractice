package com.kh.lclinic.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.http.HttpSession;

@Controller
public class CommonController {
	@GetMapping("removeAlertMsg")
	public String removeAlertMsg(HttpSession session) {
		session.removeAttribute("alertMsg");
		return "redirect:/";
	}
}
