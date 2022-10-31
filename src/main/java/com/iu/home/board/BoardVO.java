package com.iu.home.board;

import java.sql.Date;

import lombok.Data;

@Data
public class BoardVO {
	
	private Long num;
	private String writer;
	private String title;
	private String contents;
	private Long hit;
	private Date regDate;
	private Long ref;
	private Long step;
	private Long depth;
	

}
