package com.kh.spring.member.service;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import com.kh.spring.member.model.vo.Member;

public interface MemberService {
	/* 로그인 서비스 */
	Member loginMember(String userId, String userPwd);
	
	/* 회원 가입 서비스 */
	int insertMember(Member member);
	
	/* 아이디 중복체크 기능 */
	int idCheck(String userId);
	
	/* 회원 정보 수정 */
	Member updateMember(Member member);
	
	/* 회원 탈퇴 */
	int deleteMember(String userId, String userPwd);
}
