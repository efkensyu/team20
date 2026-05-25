package com.example.demo.team20_controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
@SessionAttributes(names="shainCd")
@Controller
public class Team20_menyuCon {
	
	@GetMapping("/Team20_Menyu")			
	public String index() {
		return "team20/Team20_menyu";	
	}
	
	@PostMapping(value="/Team20_Menyu", params="register")
	public String send1() {
				return "redirect:/Team20_register";
			}
	@PostMapping(value="/Team20_Menyu", params="search")
	public String send2() {
				return "redirect:/search";
			}
	@PostMapping(value="/Team20_Menyu", params="result")
	public String send3() {
				return "team20/Team20_Result";
			}
		
	}
