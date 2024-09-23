package com.kh.mybatis.member.model.vo;

public class UpdatePasswordDto {
	private String userPwd;
	private String newPassword;
	private String userId;
	
	public UpdatePasswordDto(String userPwd, String newPassword, String userId) {
		this.userPwd = userPwd;
		this.newPassword = newPassword;
		this.userId = userId;
	}

	public String getUserPwd() {
		return userPwd;
	}

	public void setUserPwd(String userPwd) {
		this.userPwd = userPwd;
	}

	public String getNewPassword() {
		return newPassword;
	}

	public void setNewPassword(String newPassword) {
		this.newPassword = newPassword;
	}

	public String getUserId() {
		return userId;
	}

	public void setUserId(String userId) {
		this.userId = userId;
	}
}
