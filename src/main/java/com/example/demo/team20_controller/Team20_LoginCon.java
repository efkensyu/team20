package com.example.demo.team20_controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Team20_LoginCon {
	
	@GetMapping("/login")			
	public String index() {
		return "team20/Team20_Login";	
	}
	
	@PostMapping("")
	public String send(@RequestParam("login.name") String name, @RequestParam("login.password") String pass, Model model) {
		model.addAttribute("log.name", name);
		model.addAttribute("log.pass", pass);
		return "team20/Team20_menyu";
	}
}