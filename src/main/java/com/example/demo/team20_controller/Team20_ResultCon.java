package com.example.demo.team20_controller;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.team20_entity.Team20_Shain;

@Controller
public class Team20_ResultCon {
	@GetMapping("/result")
	public String index(ArrayList<Team20_Shain> resultList) {
	 return "team20/Team20_Result";
	}
	
	@PostMapping("/result")
	public String send1() {
		return "team20/Team20_Detailsu";
	}
}