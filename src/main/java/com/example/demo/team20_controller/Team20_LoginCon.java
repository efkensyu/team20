package com.example.demo.team20_controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.team20_entity.Team20_Shain;
import com.example.demo.team20_service.Team20_LoginSer;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class Team20_LoginCon {
	private final Team20_LoginSer loginSer;
	
	@GetMapping("/register")			
	public String index() {
		return "team20/Team20_register";	
	}
	
	@PostMapping("")
	public String send(@RequestParam String shainCd, Model model) {
		List<Team20_Shain> userDataList;
		userDataList = loginSer.findByName(shainCd);
		if (userDataList.isEmpty()) {
		
		} else {
			
		}

		return "team20/Team20_menyu";
	}
}