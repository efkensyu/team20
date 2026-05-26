package com.example.demo.team20.team20_controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Team20_ResultCon {
	private String userid;//=社員コード
	/*@GetMapping("/Team20_Result")
	public String index(ArrayList<Team20_Shain> resultList) {
	 return "team20/Team20_Result";
	}*/
	@GetMapping("/Team20_Result")
	public String index(HttpSession session, Model model) {
		userid = (String) session.getAttribute("userid");
		System.out.println("ログイン中" + userid);
		return "team20/Team20_Result";
	}
	
	@PostMapping("/Team20_Result")
	public String send1(@RequestParam("shainCd") String shainCd) {
		return "team20/Team20_Details";
	}
}