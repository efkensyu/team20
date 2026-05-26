package com.example.demo.team20.team20_controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
@SessionAttributes(names="shainCd")
@Controller
public class Team20_menyuCon {
	
	@GetMapping("/Team20_Menyu")			
	public String index(HttpSession session,Model model) {
		String userid = (String) session.getAttribute("userid");
	    String password = (String) session.getAttribute("password");
		return "team20/Team20_menyu";	
	}
	
	@PostMapping(value="/Team20_Menyu", params="register")
	public String send1() {
				return "redirect:/Team20_register";
			}
	@PostMapping(value="/Team20_Menyu", params="search")
	public String send2() {
				return "redirect:/Team20_Search";
			}
	@PostMapping(value="/Team20_Menyu", params="result")
	public String send3() {
				return "team20/Team20_Result";
			}
		
	}
