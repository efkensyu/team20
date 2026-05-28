package com.example.demo.team20.team20_controller;

import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;

import lombok.Data;

@Data
public class Team20_RegForm {

	
	private String name;
	@NotEmpty(message = "ご自身の社員コードを入力して下さい。")
	@Size(max = 5, message = "社員コードは5文字以内で入力してください。")
	private String code;
	@NotEmpty(message = "いずれかを選択してください")
	private String janru;
	@NotEmpty(message = "いずれかを選択してください")
	private String hobby;

	private String janruNm;
	private String hobbyNm;

	@NotEmpty(message = "いずれかを選択してください")
	private String janru2;
	@NotEmpty(message = "いずれかを選択してください")
	private String hobby2;

	private String janruNm2;
	private String hobbyNm2;

	@NotEmpty(message = "いずれかを選択してください")
	private String janru3;
	@NotEmpty(message = "いずれかを選択してください")
	private String hobby3;

	private String janruNm3;
	private String hobbyNm3;

	@NotEmpty(message = "いずれかを選択してください")
	private String job;
	
	@Size(max = 200, message = "自己紹介は200文字以内で入力してください")
	private String intro;

}
