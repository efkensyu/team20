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
	

	@GetMapping("/login")			
	public String index() {
		return "team20/Team20_login";	
	}
	
	@PostMapping(value="menu", params="login")
	public String send(@RequestParam String shainCd,@RequestParam String loginPass, Model model) {
		List<Team20_Shain> userDataList;
		userDataList = loginSer.findByShainCd(shainCd);
		if (userDataList.isEmpty() && userDataList.get(0).equals(loginPass)) {
			return "team20/Team20_menyu";
		} else {
			return "team20/Team20_login";
		}
	}

	
	@PostMapping(value="firstRegist", params="regist")
	public String regist() {
		return "team20/Team20_FirstRegister";	
	}
}