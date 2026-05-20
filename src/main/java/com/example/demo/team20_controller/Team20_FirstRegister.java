package com.example.demo.team20_controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.team20_entity.Team20_Shain;
import com.example.demo.team20_service.Team20_FirstRegisterSer;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
public class Team20_FirstRegister {
	private final Team20_FirstRegisterSer registerSer;
	
	@GetMapping("/firstRegister")			
	public String index() {
		System.out.println("ファーストkidou");
		return "team20/Team20_FirstRegister";	
	}
	
	@PostMapping(value="/menu", params="regist")
	public String send(@RequestParam String shainNm,@RequestParam String shainCd, @RequestParam String loginPass, Model model) {
		List<Team20_Shain> userDataList;
		userDataList = registerSer.findByShainCd(shainCd);
		if (userDataList.isEmpty()) {
			registerSer.regist(shainNm, shainCd, loginPass);
			return "team20/Team20_menyu";	
		} else {
			return "team20/Team20_FirstRegister";	
		}
	}
	
	@GetMapping(value="/login", params="back")
	public String back() {
		return "team20/Team20_login";	
	}
}