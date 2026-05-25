package com.example.demo.team20_controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.team20_service.Team20_FirstRegisterSer;

@Controller
public class Team20_FirstRegister {
	@Autowired
	private Team20_FirstRegisterSer fRegisterSer;
	
	@GetMapping("/Team20_FirstRegister")			
	public String index(Model model) {
		model.addAttribute("registerForm", new Team20_RegisterForm());
		return "team20/Team20_FirstRegister";	
	}
	
	@PostMapping(value="/Team20_FirstRegister", params="regist")
	public String send(@ModelAttribute Team20_RegisterForm registerForm, HttpSession session) {
		String userInfo = fRegisterSer.find(registerForm.getUserid()).toString();
		String pass = "password=" + registerForm.getPassword();
		if(userInfo.contains(pass) == true) {
			System.out.println("登録済み");
			
			return "team20/Team20_FirstRegister";
		} else {
			System.out.println("登録確認");
			session.setAttribute("userid", registerForm.getUserid());
		    session.setAttribute("password", registerForm.getPassword());
		    session.setAttribute("name",  registerForm.getName());
			return "redirect:/Team20_FirstResult";
		}
	}
	
	@PostMapping(value="/Team20_FirstRegister", params="back")
	public String back(@ModelAttribute Team20_RegisterForm registerForm) {
		return "redirect:/Team20_Login";
	}
}