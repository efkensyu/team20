package com.example.demo.team20.team20_controller;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

import lombok.Data;

@Data
public class Team20_RegForm {
	
	@Max(20)
	@NotNull(message="ご自身の名前か、ニックネームを入力してください")
	private String name;
	@NotNull(message="ご自身の社員コードを入力して下さい。")
	@Max(5)
	private String code;
	@NotEmpty(message="いずれかを選択してください")
	private String janru;
	@NotEmpty(message="いずれかを選択してください")
	private String hobby;
	@NotEmpty(message="いずれかを選択してください")
	private String janru2;
	@NotEmpty(message="いずれかを選択してください")
	private String hobby2;
	@NotEmpty(message="いずれかを選択してください")
	private String janru3;
	@NotEmpty(message="いずれかを選択してください")
	private String hobby3;
	@NotEmpty(message="いずれかを選択してください")
	private String job;
	@NotNull(message="自己紹介文の入力お願いします。")
	@Max(200)
	private String intro;
	
}
