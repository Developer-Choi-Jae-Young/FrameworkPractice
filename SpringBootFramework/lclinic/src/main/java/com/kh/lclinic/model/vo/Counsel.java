package com.kh.lclinic.model.vo;

import java.sql.Date;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Counsel {
	private String userId;
	private String title;
	private String content;
	private Date createDate;
}
