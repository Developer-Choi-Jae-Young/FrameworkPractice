package com.kh.spring.member.service;

import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.kh.spring.member.dao.MemberDao;
import com.kh.spring.member.model.vo.LoginDto;
import com.kh.spring.member.model.vo.Member;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class MemberServiceImpl implements MemberService {
	private final MemberDao memberDao;
	private final SqlSessionTemplate sqlSession;
	
	/*
	 * 필드 주입 방식 : 스프링 컨테이너에서 객체를 생성한 후 @Autowired 사용한 필드에 주입
	 *
	 @Autowired
	 private SqlSessionTemplate sqlSession;
	 */
	
	/* 생성자 주입 방식
	 * @Autowired
	 * public MemberServiceImpl(SessionTemplate sqlSession) {
	 * this.sqlSesion = sqlSession;
	 * }
	 */
	
	@Override
	public Member loginMember(String userId, String userPwd) {
		return memberDao.loginMember(sqlSession, new LoginDto(userId, userPwd));
	}

	@Override
	public int insertMember(Member member) {
		return memberDao.insertMember(sqlSession, member);
	}

	@Override
	public int idCheck(String userId) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public Member updateMember(Member member) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteMember(String userId, String userPwd) {
		// TODO Auto-generated method stub
		return 0;
	}
}
