package com.example.demo.team20_controller;

import jakarta.validation.constraints.NotBlank;

import lombok.Data;

@Data
public class RegForm {
	
	@NotBlank
	private String name;
	@NotBlank
	private String janru;
	@NotBlank(message = "いずれかを選択してください")
	private String hobby;
	@NotBlank
	private String janru2;
	@NotBlank(message = "いずれかを選択してください")
	private String hobby2;
	@NotBlank
	private String janru3;
	@NotBlank(message = "いずれかを選択してください")
	private String hobby3;
	
	private String info;
	
	private String intro;
	
}
