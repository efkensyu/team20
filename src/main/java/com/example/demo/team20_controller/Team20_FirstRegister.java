package com.example.demo.team20_controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.team20_service.Team20_FirstRegisterSer;

@Controller
@SessionAttributes("registerForm")
public class Team20_FirstRegister {
	@ModelAttribute("registerForm")
	public Team20_RegisterForm setupRegisterFrom() {
		return new Team20_RegisterForm();
	}
	@Autowired
	private Team20_FirstRegisterSer fRegisterSer;
	
	@GetMapping("/Team20_FirstRegister")			
	public String index(Model model) {
		model.addAttribute("registerForm", new Team20_RegisterForm());
		return "team20/Team20_FirstRegister";	
	}
	
	@PostMapping(value="/Team20_FirstRegister", params="regist")
	public String send(@ModelAttribute("registerForm") Team20_RegisterForm registerForm) {
		String userInfo = fRegisterSer.find(registerForm.getUserid()).toString();
		String pass = "password=" + registerForm.getPassword();
		if(userInfo.contains(pass) == true) {
			System.out.println("登録済み");
			return "team20/Team20_FirstRegister";
		} else {
			System.out.println("登録確認");
			return "team20/Team20_FirstResult";
		}
	}
	
	@PostMapping(value="/Team20_FirstRegister", params="back")
	public String back() {
		return "team20/Team20_FirstRegister";
	}
}