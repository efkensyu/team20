package com.example.demo.team20_controller;

import java.util.List;

import jakarta.servlet.http.HttpSession;

//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.team20_entity.Team20_Shain;
import com.example.demo.team20_repository.Team20_RegisterResultRepository;
import com.example.demo.team20_service.Team20_RegisterResultSer;

@Controller
@SessionAttributes("regForm")
public class Team20_RegisterResultCon {

	private  Team20_RegisterResultRepository repository;
	
	private Team20_RegisterResultSer service;

	@GetMapping("/Team20_register_result")
	public String index(Model model) { // ← Model を追加
		model.addAttribute("regForm", new Team20_RegForm()); // ← この行を追加
		return "team20/Team20_Register_Result";
	}

	
	//実行ボタン
	@PostMapping(value = "/Team20_Result", params = "do")
	public String showresult(HttpSession session, Model model) { // ← Model を追加
		// セッションからログイン中の社員を取得
		Team20_Shain RegForm = (Team20_Shain) session.getAttribute("RegForm");

		if (RegForm == null) {
			return "team20/Team20_Register_Result";
		}

		List<Team20_Shain> resultList = service.getMatchingResult(RegForm);
		model.addAttribute("resultList", resultList);
		model.addAttribute("loginList", RegForm);
		return "team20/Team20_Result";
	}

}