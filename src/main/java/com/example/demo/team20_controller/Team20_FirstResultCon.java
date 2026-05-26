package com.example.demo.team20_controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.team20_service.Team20_FirstRegisterSer;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class Team20_FirstResultCon {
	private final Team20_FirstRegisterSer fRegisterSer;
	
	
	
	
	@GetMapping("/Team20_FirstResult")			
	public String index(HttpSession session, Model model) {
		String userid = (String) session.getAttribute("userid");
	    String password = (String) session.getAttribute("password");
	    String name = (String) session.getAttribute("name");
	    Team20_RegisterForm form = new Team20_RegisterForm();
        form.setUserid(userid);
        form.setPassword(password);
        form.setName(name);
        model.addAttribute("registerForm", form);
		return "team20/Team20_FirstResult";	
	}
	
	@PostMapping(value="/Team20_FirstResult", params="regist")
	public String send(HttpSession session) {
		  String userid = (String) session.getAttribute("userid");
		  String password = (String) session.getAttribute("password");  
		  String name = (String) session.getAttribute("name");
		  System.out.println("登録完了");
		  fRegisterSer.registShain(userid, name);
		  fRegisterSer.registLogin(userid, password);
		  return "redirect:/Team20_Login";
	}
	
	@PostMapping(value="/Team20_FirstResult", params="back")
	public String back() {
		return "redirect:/Team20_FirstRegister";
	}
}