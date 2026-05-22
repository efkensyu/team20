package com.example.demo.team20_controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.team20_entity.Team20_Shain;
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
	public String send(@RequestParam String shainCd,@RequestParam String loginPass, Model model) {
		List<Team20_Shain> userDataList;
		userDataList = loginSer.findByShainCd(shainCd);
		System.out.println(userDataList.toString());
		if (userDataList.isEmpty()) {
			System.out.println("ログイン失敗1");
			return "team20/Team20_login";
		} else if ( userDataList.get(0).equals(loginPass)) {
			System.out.println("ログイン成功");
			return "team20/Team20_menyu";
		} else {
			System.out.println("ログイン失敗");
			return "team20/Team20_login";
		}
	}

	@PostMapping(value="/login", params="regist")
	public String regist() {
		System.out.println("登録遷移");
		return "team20/Team20_FirstRegister";	
	}
}