package com.example.demo.team20_controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.team20_entity.Team20_Shain;
import com.example.demo.team20_service.Team20_DetailsService;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Controller
public class Team20_DetailsCon {
	private final Team20_DetailsService service;

	@GetMapping("/Team20_Details")			

	public String index(@ModelAttribute("shainCd") String shainCd, Model model) {
		if (shainCd != null) {
		Team20_Shain shain = service.findPerson(shainCd);
		model.addAttribute("userData",shain);
		}
		return "team20/Team20_Details";	
	}
	
	@PostMapping("/Team20_Details")
	public String send() {
		return "team20/Team20_Result";
	}
}