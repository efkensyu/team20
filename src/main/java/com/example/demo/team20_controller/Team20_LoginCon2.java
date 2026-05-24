package com.example.demo.team20_controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.team20_service.Team20_LoginSer2;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class Team20_LoginCon2 {
	private final Team20_LoginSer2 loginSer2;
	

	@GetMapping("/login2")			
	public String index() {
		return "team20/Team20_Login2";	
	}
	
	@PostMapping(value="/login2", params="login")
	public String send(@RequestParam String userid, @RequestParam String loginPass, Model model) {
		String userInfo = loginSer2.find(userid).toString();
		String pass = "password=" + loginPass;
		if(userInfo.contains(pass) == true) {
			return "team20/Team20_menyu";
		} else {
			System.out.println(loginSer2.find(userid));
			return "team20/Team20_Login2";
		}
	}

	@PostMapping(value="/login2", params="regist")
	public String regist() {
		System.out.println("登録遷移");
		return "team20/Team20_FirstRegister";	
	}
}