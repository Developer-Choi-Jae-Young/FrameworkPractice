package com.kh.mybatis.member.service;

import com.kh.mybatis.member.model.vo.DeleteMemberDto;
import com.kh.mybatis.member.model.vo.Member;
import com.kh.mybatis.member.model.vo.UpdatePasswordDto;

public interface MemberService {
	/* 로그인 요청 관련 기능 */
	Member loginMember(Member member);
	
	/* 회원가입 요청 관련 기능 */
	int insertMember(Member member);
	
	/* 회원 정보 수정 관련 기능 */
	Member updateMember(Member member);
	
	/* 탈퇴 요청 관련 기능 */
	int deleteMember(DeleteMemberDto deleteMemberDto);
	
	/* 중복 검사 관련 기능 */
	int duplicateUserId(String userId);
	
	Member updatePassword(UpdatePasswordDto updatePasswordDto);
}
