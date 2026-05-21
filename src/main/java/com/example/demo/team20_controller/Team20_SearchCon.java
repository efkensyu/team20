package com.example.demo.team20_controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Team20_SearchCon {
	@GetMapping("/search")
	public String index(Model model) {
		model.addAttribute("regForm",new RegForm());
		return "team20/Team20_Search";
	}
	
	@PostMapping(value="/search",params="back")
	public String send1() {
		return "team20/Team20_menyu";
	}
	@PostMapping(value="/search",params="search")
	public String send2(@ModelAttribute RegForm regForm) {
		System.out.println(regForm);
		return "team20/Team20_Result";
	}
}