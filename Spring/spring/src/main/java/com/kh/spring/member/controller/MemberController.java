package com.kh.spring.member.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.aop.support.AopUtils;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.kh.spring.member.model.vo.Member;
import com.kh.spring.member.service.MemberService;
import com.kh.spring.member.service.MemberServiceImpl;

import lombok.RequiredArgsConstructor;

@Controller // Controller 어노테이션 추가 시 빈 스캐닝을 통해 자동으로 빈 등록이 됨
@RequestMapping("/member")	// 공통적으로 사용될 url 주소
@RequiredArgsConstructor
public class MemberController {
	private final MemberService memberService;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	//private MemberService memberService = new MemberSErviceImpl();
	/*
	 * * 기존 객체 생성 방식 : 객체 간의 결합도가 높아짐 (소스코드 수정 시 사용된 부분을 전부 변경)
	 * 						서비스가 동시에 많이 사용되었을 경우 그 만큼 객체 생성
	 * 
	 *  * Spring을 이용한 방식 (DI : Dependency Injection)
	 *    : 객체를 생성하여 주입해줌
	 *    new 키워드 없이 @Autowired 만 사용
	 *    
	 *    - 필드 주입 방식
	 *      : 스프링 컨테이너에서 객체를 생성한 후 @Autowired가 붙은 필드에 의존성을 주입
	 *      
	 *    - 생성자 주입 방식
	 *      : 스프링 컨테이너에서 해당 객체를 생성할 때 생성자를 통해서 필요한 의존성을 주입
	 */
	
	/*
	@RequestMapping("/login") // RequestMapping 어노테이션 추가 시 HandlerMapping 등록 (url 주소 작성)
	public void loginMember() {
		System.out.println("로그인");
	}
	*/
	
	/*
	@RequestMapping("/login") // RequestMapping 어노테이션 추가 시 HandlerMapping 등록 (url 주소 작성)
	public void loginMember(@RequestParam String userId, @RequestParam String userPwd) {
		memberService.loginMember(userId, userPwd);
	}
	*/
	
	/*
	 * * 요청 시 전달되는 데이터에 대한 처리 방법
	 * 
	 * 	 1) HttpServletRequest 이용 (기존 servlet 방식)
	 * 		: 해당 메소드의 매개변수로 HttpServletRequest 타입을 작성하면
	 * 		  스프링 컨테이너에서 해당 메소드 호출 시 자동으로 객체를 생성하여 전달해줌
	 */
	/*
	@RequestMapping("/login")
	public String loginMember(HttpServletRequest request) {
		String userId = request.getParameter("userId");
		String userPwd = request.getParameter("userPwd");
		
		System.out.println("ID -----> " + userId);
		System.out.println("PW -----> " + userPwd);
		return "main";
	}
	*/
	
	/*
	 *  2) RequestParam 어노테이션 이용
	 *     : request.getParameter("키값") : 밸류 <<- 이 작업을 대신해주는 어노테이션
	 */
	/*
	@RequestMapping("/login")
	public String loginMember(@RequestParam(value="userId", defaultValue="xxx") String userId, @RequestParam("userPwd") String userPwd) {
		System.out.println("ID -----> " + userId);
		System.out.println("PW -----> " + userPwd);
		return "main";
	}
	*/
	
	/*
	 * 3) @RequestParam 생략
	 * 	  => 주의! 매개변수명 요청시 전달되는 키값과 동일하게 작성해야 함
	 */
	/*
	@RequestMapping("/login")
	public String loginMember(String userId, String userPwd) {
		System.out.println("ID -----> " + userId);
		System.out.println("PW -----> " + userPwd);
		return "main";
	}
	*/
	
	/*
	 * 4) 커맨드 객체 방식
	 * 	  : 요청 시 전달되는 데이터를 vo클래스 타입으로 받고자 하는 경우
	 * 
	 * 	  매개변수 타입을 vo클래스타입으로 작성
	 * 	  전달되는 데이터의 키값을 받고자하는 vo클래스의 필드명과 일치하도록 해줘야함.
	 * 
	 * 	  스프링 컨테이너가 해당 vo객체를 기본생성자로 생성 후
	 * 	  setter 메소드를 사용하여 요청 시 전달 값을 해당 필드에 저장함
	 * 
	 *    *주의* 요청 키값을 필드명과 동일하게 전달해야 함!
	 */
	@RequestMapping("/login")
	public String loginMember(Member member, Model model, HttpSession session) {
		System.out.println("ID -----> " + member.getUserId());
		System.out.println("PW -----> " + member.getUserPwd());
		Member m = memberService.loginMember(member.getUserId(), member.getUserPwd());
		
		if(m != null && bCryptPasswordEncoder.matches(member.getUserPwd(), m.getUserPwd())) {
			System.out.println("로그인 성공!");
			// 세션영역에 로그인 정보 저장
			session.setAttribute("loginUser", m);
			// url 재요청 (메인페이지)
			return "redirect:/";
		} else {
			System.out.println("로그인 실패!");
			// request영역에 에러메시지 저장
			// => Model 객체 : requestScop
			model.addAttribute("errorMsg", "로그인에 실패하였습니다.");
			// 에러페이지로 응답 (포워딩)
			return "common/errorPage";
		}
	}
	
	@RequestMapping("/logout")
	public String logoutMember(HttpSession session) {
		session.invalidate();
		return "redirect:/";
	}
	
	@RequestMapping("/enrollForm")
	public String enrollForm() {
		
		return "member/enrollForm";
	}
	
	@RequestMapping("/insert")
	public String insert(Member m, HttpSession session, Model model) {
		// => 한글 인코딩 처리 --> web.xml 파일에 필터를 등록하여 처리
		// => 숫자 타입의 데이터(나이,age)가 같이 없을 경우 400 에러 발생
		//		--> DB 처리 시 자동 형변환 되므로 정수형->문자열 형변환하여 처리
		System.out.println(m);
		// => 비밀번호 값을 입력된 값 그대로(평문) 저장하는 것이 아니라
		// 	  원래 값을 알아보기 어렵게 만든 값(암호문)으로 저장할 것임!
		//	  * Spring-security 라이브러리 추가 (pom.xml 등록)
		//	  * BCryptPasswordEncoder 클래스를 빈으로 등록 (xml 파일 사용)
		// 	  * 추가한 파일을 서버 구동 시 pre-loading 할 수 있도록 web.xml파일에 설정
		
		System.out.println("평문 --> " + m.getUserPwd());
		System.out.println("평문 --> " + bCryptPasswordEncoder.encode(m.getUserPwd()));
		
		m.setUserPwd(bCryptPasswordEncoder.encode(m.getUserPwd()));
		// => Member 객체에 비밀번호 평문을 암호문으로 변경
		
		int result = memberService.insertMember(m);
		
		if(result > 0) {
			// 회원가입 성공 => 성공메시지 + 메인페이지 url 재요청
			session.setAttribute("alertMsg", "회원가입에 성공했습니다.");
			return "redirect:/";
		} else {
			// 회원가입 실패 => 에러 메시지 + 에러페이지 포워딩
			model.addAttribute("errorMsg", "회원가입에 실패했습니다.");
			return "common/errorPage";
		}
	}
}
