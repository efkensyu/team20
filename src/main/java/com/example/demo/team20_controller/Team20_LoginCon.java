package com.example.demo.team20_controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.team20_entity.Team20_Shain;
import com.example.demo.team20_service.Team20_LoginSer;

@Controller
public class Team20_LoginCon {
	
	@GetMapping("/login")			
	public String index() {
		return "team20/Team20_Login";	
	}
	
	@PostMapping("")
	public String send(@RequestParam String loginName, @RequestParam String loginPass, Model model) {
		List<Team20_Shain> userDataList;
		userDataList = Team20_LoginSer.findByNameAndPass(loginName, loginPass);
		if (userDataList.isEmpty()) {
		
		} else {
			
		}
		return "team20/Team20_menyu";
	}
}