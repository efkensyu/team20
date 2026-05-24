package com.example.demo.team20_controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.team20_service.Team20_FirstRegisterSer;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@SessionAttributes(names = "shainCd")
public class Team20_FirstRegisterCon {
	private final Team20_FirstRegisterSer fRegisterSer;
	
	@GetMapping("/firstRegister")			
	public String index() {
		return "team20/Team20_FirstRegister";	
	}
	
	@PostMapping(value="/firstRegister", params="regist")
	public String send(@RequestParam String shainNm,@RequestParam String shainCd, @RequestParam String loginPass, Model model) {
		String userInfo = fRegisterSer.find(shainCd).toString();
		String pass = "password=" + loginPass;
		String userid = shainCd;
		String password = loginPass;
		if(userInfo.contains(pass) == true) {
			System.out.println("登録済み");
			return "team20/Team20_menyu";
		} else {
			System.out.println("登録完了");
			fRegisterSer.registShain(shainCd, shainNm);
			fRegisterSer.registLogin(userid, password);
			return "team20/Team20_Login";
		}
	}
	
	@PostMapping(value="/firstRegister", params="back")
	public String back() {
		return "team20/Team20_login";
	}
}