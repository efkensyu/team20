package com.example.demo.team20.team20_controller;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import lombok.Data;

@Data
public class Team20_LoginForm {
	
	@NotBlank
	@Size(min = 5, max = 5, message = "社員コードは5桁です")
	private String userid;
	
	@NotBlank
	private String password;
}
