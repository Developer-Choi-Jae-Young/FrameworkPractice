package com.kh.mybatis.member.model.dao;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.member.model.vo.DeleteMemberDto;
import com.kh.mybatis.member.model.vo.Member;
import com.kh.mybatis.member.model.vo.UpdatePasswordDto;

public class MemberDao {
	public Member loginMember(SqlSession sqlSession, Member member) {
		/*
		Member m = null;
		
		m = sqlSession.selectOne("memberMapper.loginMember", member);
		// selectOne() : 조회된 결과가 없을 경우 null을 반환
		return m;
		*/
		
		return sqlSession.selectOne("memberMapper.loginMember", member);
	}
	
	public int insertMember(SqlSession sqlSession, Member member) {
		return sqlSession.insert("memberMapper.insertMember", member);
	}
	
	public int duplicateUserId(SqlSession sqlSession, String userId) {
		int result = 0;
		
		result = sqlSession.selectOne("memberMapper.duplicateUserId", userId);
		
		return result;
	}
	
	public int updateMember(SqlSession sqlSession, Member member) {
		return sqlSession.update("memberMapper.updateMember", member);
	}
	
	public Member findMember(SqlSession sqlSession, String userId) {
		return sqlSession.selectOne("memberMapper.findMember", userId);
	}
	
	public int updatePassword(SqlSession sqlSession, UpdatePasswordDto updatePasswordDto) {
		return sqlSession.update("memberMapper.updatePassword", updatePasswordDto);
	}
	
	public int deleteMember(SqlSession sqlSession, DeleteMemberDto deleteMemberDto) {
		return sqlSession.update("memberMapper.deleteMember", deleteMemberDto);
	}
}
