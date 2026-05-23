package com.example.demo.team20_controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.team20_entity.Team20_Login;
import com.example.demo.team20_service.Team20_LoginSer;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@SessionAttributes(names = "shainCd")
public class Team20_LoginCon {
	private final Team20_LoginSer loginSer;
	

	@GetMapping("/login")			
	public String index() {
		return "team20/Team20_Login";	
	}
	
	@PostMapping(value="/login", params="login")
	public String send(@ModelAttribute Team20_Login login, Model model, BindingResult result) {
		System.out.println(login.getUserid());
		if(result.hasErrors()) {
			System.out.println("えらー1");
			return "team20/Team20_login";
		}
		if(!(loginSer.isPass(login))) {
			model.addAttribute("error", "エラー");
			System.out.println("えらー2");
			return "team20/Team20_login";
		}
		
		
//		List<Team20_Shain> shainData;
//		shainData = loginSer.retShainData(login.getUser());
//		model.addAttribute("shainData",shainData);
		System.out.println("めにゅー");
		return "team20/Team20_menyu";
	}

	@PostMapping(value="/login", params="regist")
	public String regist() {
		System.out.println("登録遷移");
		return "team20/Team20_FirstRegister";	
	}
}