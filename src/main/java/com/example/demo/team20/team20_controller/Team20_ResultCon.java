package com.example.demo.team20.team20_controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class Team20_ResultCon {
	/*@GetMapping("/Team20_Result")
	public String index(ArrayList<Team20_Shain> resultList) {
	 return "team20/Team20_Result";
	}*/
	@GetMapping("/Team20_Result")
	public String index(Model model) {
	 return "team20/Team20_Result";
	}
	
	@PostMapping("/Team20_Result")
	public String send1(@RequestParam String shainCd) {
		return "team20/Team20_Details";
	}
}