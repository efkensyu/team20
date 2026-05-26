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
import com.example.demo.team20.team20_repository.Team20_RegisterResultRepository;
import com.example.demo.team20.team20_service.Team20_RegisterResultSer;

@Controller
@SessionAttributes("regForm")
public class Team20_RegisterResultCon {

	private final Team20_RegisterResultSer registerResultSer;
	private final Team20_RegisterResultRepository shainRepository;
	
	private String userid;//=社員コード

	public Team20_RegisterResultCon(Team20_RegisterResultSer registerResultSer,Team20_RegisterResultRepository shainRepository) {
		this.registerResultSer = registerResultSer;
		this.shainRepository = shainRepository;
	}

	@GetMapping("/Team20_Register_Result")
	public String index(HttpSession session,Model model) { 
		userid = (String) session.getAttribute("userid");
		System.out.println("ログイン中" + userid);
		model.addAttribute("regForm", new Team20_RegForm()); 
		return "team20/Team20_Register_Result";
	}

	//戻るボタン
	@PostMapping(value = "/Team20_Result", params = "back")
	public String back(@ModelAttribute Team20_RegForm regForm) {
		return "team20/Team20_Register";
	}

	//確定ボタン
	@PostMapping(value = "/Team20_Result", params = "do")
	public String showresult(HttpSession session, Model model) {
		
		String userid = (String) session.getAttribute("userid");
		System.out.println("実行ボタン　ログイン中："+userid);
		
		if(userid == null) {
			return "redirect:/Team20_Register_Result";
		}
	// 指定されたユーザーIDで社員情報を検索（存在しない場合はnullを代入）
		Team20_Shain loginShain = shainRepository.findById(userid).orElse(null);
//
		if (loginShain == null) {
			return "team20/Team20_Register_Result";
		}
		List<Team20_Shain> resultList = registerResultSer.getMatchingResult(loginShain);
		model.addAttribute("resultList", resultList);
		model.addAttribute("loginList", loginShain);
		return "team20/Team20_Result";
	}

}