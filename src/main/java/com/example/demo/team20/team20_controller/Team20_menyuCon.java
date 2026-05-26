package com.example.demo.team20.team20_controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.team20.team20_service.Team20_MenyuSer;
@SessionAttributes(names="shainCd")
@Controller
public class Team20_menyuCon {
	private String userid;
	
	@Autowired
	private Team20_MenyuSer menyuSer;
	
	@GetMapping("/Team20_Menyu")			
	public String index(HttpSession session,Model model) {
		userid = (String) session.getAttribute("userid");
		String loginName = menyuSer.find(userid);
		model.addAttribute("name", loginName);
		System.out.println("ログイン中" + userid);
		return "team20/Team20_menyu";
	}
	
	@PostMapping(value="/Team20_Menyu", params="register")
	public String send1(HttpSession session,Model model) {
		session.setAttribute("userid", userid);
		return "redirect:/Team20_Register";
	}
	@PostMapping(value="/Team20_Menyu", params="search")
	public String send2(HttpSession session,Model model) {
		session.setAttribute("userid", userid);
		return "redirect:/Team20_Search";
	}
	@PostMapping(value="/Team20_Menyu", params="result")
	public String send3(HttpSession session,Model model) {
		session.setAttribute("userid", userid);
		return "redirect:/Team20_Result";
	}		
}
