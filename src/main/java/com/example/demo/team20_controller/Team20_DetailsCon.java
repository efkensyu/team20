package com.example.demo.team20_controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Team20_DetailsCon {
	
	@GetMapping("/detail")			
	public String index() {
		return "team20/Team20_Details";	
	}
	
	@PostMapping("/detail")
	public String send() {
		return "team20/Team20_Result";
	}
}