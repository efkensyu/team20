package com.example.demo.team20_controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class Team20_menyuCon {
	
	@GetMapping("/menyu")			
	public String index() {
		return "team20/Team20_menyu";	
	}
	
	@PostMapping(value="/menyu", params="register")
	public String send1() {
				return "team20/Team20_register";
			}
	@PostMapping(value="/menyu", params="search")
	public String send2(Model model) {
		model.addAttribute("regForm",new RegForm());
				return "team20/Team20_Search";
			}
	@PostMapping(value="/menyu", params="result")
	public String send3() {
				return "team20/Team20_Result";
			}
		
	}
