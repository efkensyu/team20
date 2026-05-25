package com.example.demo.team20_controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.team20_entity.Team20_Shain;
import com.example.demo.team20_service.Team20_searchservice;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Controller
public class Team20_SearchCon {
	private final Team20_searchservice service;
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
	public String send2(@ModelAttribute("regForm") RegForm regForm,Model model) {
		System.out.println("Post実行");
		List<Team20_Shain>userDataList =service.findmatch(regForm.getName(),regForm.getJanru(),regForm.getHobby(),regForm.getJob());
		model.addAttribute("userDataList",userDataList);
		System.out.println(regForm);
		return "team20/Team20_Result";
	}
}