package com.kh.khEmail.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class AuthCodeDto {
	private String email;
	private String code;
}
