package com.example.demo.team20_controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.demo.team20_entity.Team20_Shain;
import com.example.demo.team20_service.Team20_DetailsService;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Controller
public class Team20_DetailsCon {
	private final Team20_DetailsService service;
	@GetMapping("/Team20_Details")			
	public String index(@RequestParam("code") String shaincd,Model model) {
		Team20_Shain shain = service.findPerson(shaincd);
		model.addAttribute("userData",shain);
		return "team20/Team20_Details";	
	}
	
	@PostMapping("/Team20_detail")
	public String send() {
		return "team20/Team20_Result";
	}
}