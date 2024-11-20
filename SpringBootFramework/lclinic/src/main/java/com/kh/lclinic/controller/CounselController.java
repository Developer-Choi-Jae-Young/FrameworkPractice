package com.kh.lclinic.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.kh.lclinic.model.vo.Counsel;
import com.kh.lclinic.model.vo.User;
import com.kh.lclinic.service.CounselService;

import jakarta.servlet.http.HttpSession;
import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class CounselController {
	private final CounselService counselService;
	
	@GetMapping("counsel")
	public String counselPage(Model model, HttpSession session) {		
		// request scope에 로그인한 사용자가 추가한 상담 내역을 저장!
		User users = (User)session.getAttribute("user");
		List<Counsel> counselArr = counselService.selectAllCounselByUserId(users.getId());
		model.addAttribute("counselArr", counselArr);
		
		System.out.println(counselArr.toString());
		
		return "counsel/counselList";
	}
	
}
