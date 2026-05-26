package com.example.demo.team20.team20_controller;

import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.team20.team20_entity.Team20_Shain;
import com.example.demo.team20.team20_service.Team20_searchservice;

import lombok.RequiredArgsConstructor;
@RequiredArgsConstructor
@Controller
@SessionAttributes("resultList")
public class Team20_SearchCon {
	private String userid;//=社員コード
	private final Team20_searchservice service;
@InitBinder
	public void initBinder(WebDataBinder binder) {
	    // 送られてきた文字列が空文字（""）だった場合、自動的に null に変換する設定
	    binder.registerCustomEditor(String.class, new org.springframework.beans.propertyeditors.StringTrimmerEditor(true));
	}
	@GetMapping("/Team20_Search")
	public String index(HttpSession session,Model model) {
		userid = (String) session.getAttribute("userid");
		System.out.println("ログイン中" + userid);
		model.addAttribute("regForm",new Team20_RegForm());
	 return "team20/Team20_Search";
	}
	
	@PostMapping(value="/Team20_Search",params="back")
	public String send1() {
		return "team20/Team20_menyu";
	}

	@PostMapping(value="/Team20_Search",params="clear")
	public String send2(Model model) {
		model.addAttribute("regForm", new Team20_RegForm());
		return "team20/Team20_Search";
	}
	@PostMapping(value="/Team20_Search",params="search")
	public String send3(@ModelAttribute Team20_RegForm regForm,Model model) {
		
		System.out.println("Post実行");
		List<Team20_Shain>resultList =service.findmatch(regForm.getName(),regForm.getJanru(),regForm.getHobby(),regForm.getJob());
		System.out.println(resultList);
		model.addAttribute("resultList",resultList);
		return "redirect:/Team20_Result";
	}
}