package com.example.demo.team20_controller;

//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

@Controller
@SessionAttributes("regForm")
public class Team20_RegisterResultCon {
	
	@GetMapping("/Team20_register_result")
	public String index(Model model) { // ← Model を追加
		model.addAttribute("regForm", new RegForm()); // ← この行を追加
		return"team20/Team20_register_result";
	}

//	@PostMapping("/Team20_register_result")
//	public String send1(@ModelAttribute RegForm regForm, SessionStatus sessionStatus) {
//		
//		return "team20/Team20_register_result";
//	}
//	
	//実行ボタン
		@PostMapping(value = "/Team20_Result", params = "do")
		public String register(@ModelAttribute RegForm regForm, SessionStatus sessionStatus) {
			return "team20/Team20_Result";
		}
	
	
}