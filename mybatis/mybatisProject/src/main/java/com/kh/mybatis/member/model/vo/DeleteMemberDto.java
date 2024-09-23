package com.kh.mybatis.member.model.vo;

public class DeleteMemberDto {
	private String userId;
	private String userPwd;
	
	public DeleteMemberDto(String userId, String userPwd) {
		this.userId = userId;
		this.userPwd = userPwd;
	}
	public String getUserId() {
		return userId;
	}
	public void setUserId(String userId) {
		this.userId = userId;
	}
	public String getUserPwd() {
		return userPwd;
	}
	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}
	
	
}
