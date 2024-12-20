package com.kh.mybatis.member.service;

import org.apache.ibatis.session.SqlSession;

import com.kh.mybatis.member.model.dao.MemberDao;
import com.kh.mybatis.member.model.vo.DeleteMemberDto;
import com.kh.mybatis.member.model.vo.Member;
import com.kh.mybatis.member.model.vo.UpdatePasswordDto;
import com.kh.mybatis.template.MybatisTemplate;

public class MemberServiceImpl implements MemberService {

	@Override
	public Member loginMember(Member member) {
		Member m = null;
		
		/*
		 * * 기존 JDBC 방식
		 * 	 - Connection 객체 생성
		 * 	 - DAO객체 전달(Connection, 요청된 데이터)
		 * 	 - 결과에 따라 트랜잭션 처리, Connection 객체 반납(close)
		 * 	 - 결과를 반환
		 */
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		m = new MemberDao().loginMember(sqlSession, member);
		
		sqlSession.close();
		
		return m;
	}

	@Override
	public int insertMember(Member member) {
		int result = 0;
		
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		result = new MemberDao().insertMember(sqlSession, member);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		sqlSession.close();
		return result;
	}

	@Override
	public Member updateMember(Member member) {
		Member m = null;
		
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		int result = new MemberDao().updateMember(sqlSession, member);
		
		if(result > 0) {
			sqlSession.commit();
			
			m = findMember(member.getUserId());
		} else {
			sqlSession.rollback();
		}
		
		
		sqlSession.close();
		
		return m;
	}

	@Override
	public int deleteMember(DeleteMemberDto deleteMemberDto) {
		int result = 0;
		
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		result = new MemberDao().deleteMember(sqlSession, deleteMemberDto);
		
		if(result > 0) {
			sqlSession.commit();
		} else {
			sqlSession.rollback();
		}
		
		return result;
	}

	@Override
	public int duplicateUserId(String userId) {
		int result = 0;
		
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		result = new MemberDao().duplicateUserId(sqlSession, userId);
		
		sqlSession.close();
		
		return result;
	}
	
	public Member findMember(String userId) {
		Member member = null;
		
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		member = new MemberDao().findMember(sqlSession, userId);
		
		return member;
	}

	@Override
	public Member updatePassword(UpdatePasswordDto updatePasswordDto) {
		Member member = null;
		
		SqlSession sqlSession = MybatisTemplate.getSqlSession();
		
		int result = new MemberDao().updatePassword(sqlSession, updatePasswordDto);
		
		if(result > 0) {
			sqlSession.commit();
			
			member = findMember(updatePasswordDto.getUserId());
		} else {
			sqlSession.rollback();
		}
		
		return member;
	}
}
