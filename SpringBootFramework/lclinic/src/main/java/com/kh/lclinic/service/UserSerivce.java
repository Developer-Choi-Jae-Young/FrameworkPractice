package com.kh.lclinic.service;

import org.springframework.stereotype.Service;

import com.kh.lclinic.model.mapper.UserMapper;
import com.kh.lclinic.model.vo.User;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class UserSerivce {
	private final UserMapper userMapper;
	
	public User loginUser(User user) {
		return userMapper.loginUser(user.getId(), user.getPassword());
	}
}
