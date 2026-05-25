package com.example.demo.team20_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.team20_service.Team20_LoginSer;

@Controller
@SessionAttributes("loginForm")
public class Team20_LoginCon {
	@ModelAttribute("loginForm")
	public Team20_LoginForm setupLoginFrom() {
		return new Team20_LoginForm();
	}
	
	@Autowired
	private Team20_LoginSer loginSer;
	

	@GetMapping("/Team20_Login")			
	public String index(Model model) {
		model.addAttribute("loginForm", new Team20_LoginForm());
		return "team20/Team20_Login";	
	}
	
	@PostMapping(value="/Team20_Login", params="login")
	public String send(@ModelAttribute("loginForm") Team20_LoginForm loginForm, Model model) {
		String userInfo = loginSer.find(loginForm.getUserid()).toString();
		String pass = "password=" + loginForm.getPassword();
		if(userInfo.contains(pass) == true) {
			return "team20/Team20_menyu";
		} else {
			System.out.println("ログイン失敗");
			model.addAttribute("loginForm", loginForm);
			return "team20/Team20_Login";
		}
	}

	@PostMapping(value="/Team20_Login", params="regist")
	public String regist() {
		System.out.println("登録遷移");
		return "team20/Team20_FirstRegister";	
	}
}