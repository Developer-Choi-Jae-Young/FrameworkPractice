package com.kh.spring.member.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.kh.spring.member.model.vo.LoginDto;
import com.kh.spring.member.model.vo.Member;

import lombok.RequiredArgsConstructor;

@Repository
public class MemberDao {	
	public Member loginMember(SqlSession sqlSession, LoginDto loginDto) {
		return sqlSession.selectOne("memberMapper.loginMember", loginDto);
	}
	
	public int insertMember(SqlSession sqlSession, Member member) {
		return sqlSession.insert("memberMapper.insertMember", member);
	}
}
