package com.example.demo.team20_controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Team20_ResultCon {
	@GetMapping("/result")
	public String index() {
		
	 return "team20/Team20_Result";
	}
	
	@PostMapping("/result")
	public String send1() {
		return "redirect:/menyu";
	}
}