package com.example.demo.team20.team20_controller;

import jakarta.validation.constraints.Size;

import lombok.Data;

@Data
public class Team20_SearchForm {
	
	@Size(min=0,max=30,message="名前は30文字以下にしてください")
	private String name;
	
	private String code;
	
	private String janru;
	
	private String hobby;
	
	private String janru2;
	
	private String hobby2;
	
	private String janru3;
	
	private String hobby3;
	
	private String job;
	
	private String intro;
	
}
