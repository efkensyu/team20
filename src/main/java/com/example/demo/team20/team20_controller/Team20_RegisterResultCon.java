package com.example.demo.team20.team20_controller;

import java.util.List;

import jakarta.servlet.http.HttpSession;

//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.team20.team20_entity.Team20_Shain;
import com.example.demo.team20.team20_service.Team20_RegisterResultSer;

@Controller
@SessionAttributes("regForm")
public class Team20_RegisterResultCon {

	private final Team20_RegisterResultSer registerResultSer;

	public Team20_RegisterResultCon(Team20_RegisterResultSer registerResultSer) {
		this.registerResultSer = registerResultSer;
	}

	@GetMapping("/Team20_Register_Result")
	public String index(Model model) { // ← Model を追加
		model.addAttribute("regForm", new Team20_RegForm()); // ← この行を追加
		return "team20/Team20_Register_Result";
	}

	//戻るボタン
	@PostMapping(value = "/Team20_Result", params = "back")
	public String back(@ModelAttribute Team20_RegForm regForm) {
		return "team20/Team20_Register";
	}

	//実行ボタン
	@PostMapping(value = "/Team20_Result", params = "do")
	public String showresult(HttpSession session, Model model) { // ← Model を追加
		// セッションからログイン中の社員を取得
		Team20_Shain Team20_RegForm = (Team20_Shain) session.getAttribute("Team20_RegForm");

		if (Team20_RegForm == null) {
			return "team20/Team20_Register_Result";
		}
		List<Team20_Shain> resultList = registerResultSer.getMatchingResult(Team20_RegForm);
		model.addAttribute("resultList", resultList);
		model.addAttribute("loginList", Team20_RegForm);
		return "team20/Team20_Result";
	}

	@GetMapping(value = "/Team20_Result", params = "do")
	public String showresultGet(HttpSession session, Model model) { // ← Model を追加
		// セッションからログイン中の社員を取得
		Team20_Shain Team20_RegForm = (Team20_Shain) session.getAttribute("Team20_RegForm");

		if (Team20_RegForm == null) {
			return "team20/Team20_Register_Result";
		}

		//ボタン

		List<Team20_Shain> resultList = registerResultSer.getMatchingResult(Team20_RegForm);
		model.addAttribute("resultList", resultList);
		model.addAttribute("loginList", Team20_RegForm);
		return "team20/Team20_Result";
	}

}