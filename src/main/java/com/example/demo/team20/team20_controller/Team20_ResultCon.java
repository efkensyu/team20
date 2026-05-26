package com.example.demo.team20.team20_controller;

import java.util.ArrayList;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.team20.team20_entity.Team20_Shain;

@Controller
@SessionAttributes("resultList")
public class Team20_ResultCon {
	private String userid;//=社員コード
	@ModelAttribute("resultList")
	public ArrayList<Team20_Shain> setupresultList(){
		return new ArrayList<Team20_Shain>();
	}
	/*@GetMapping("/Team20_Result")
	public String index(ArrayList<Team20_Shain> resultList) {
	 return "team20/Team20_Result";
	}*/
	@GetMapping("/Team20_Result")
	public String index(HttpSession session, Model model) {
		userid = (String) session.getAttribute("userid");
		System.out.println("ログイン中" + userid);
		return "team20/Team20_Result";
	}
	
	@PostMapping("/Team20_Result")
	public String send1(@RequestParam("shainCd") String shainCd,RedirectAttributes redirectAttributes) {
		redirectAttributes.addFlashAttribute("shainCd", shainCd);
		System.out.println(shainCd);
		return "redirect:/Team20_Details";
	}
}