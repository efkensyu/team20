package com.example.demo.team20_controller;

//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.demo.team20_service.Team20_RegisterSer;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@SessionAttributes("regForm")
public class Team20_RegisterCon {
	
	private final Team20_RegisterSer service;
	
	//	@ModelAttribute("regForm")
	//	public RegForm setup() {
	//		return new RegForm();
	//	}
	//	@GetMapping("/Team20_register")			
	//	public String index() {
	//		return "team20/Team20_register";	
	//	}
	@GetMapping("/Team20_register")
	public String index(Model model) { // ← Model を追加
		model.addAttribute("regForm", new RegForm()); // ← この行を追加
		return"team20/Team20_register";
	}

//	@PostMapping("/Team20_register_result")
//	public String send1(@ModelAttribute RegForm regForm, SessionStatus sessionStatus) {
//		
//		return "team20/Team20_register_result";
//	}
//	
	//登録ボタン
		@PostMapping(value = "/Team20_register_result", params = "regit")
		public String register(@ModelAttribute RegForm regForm) {
			
			service.Proupdate(regForm);
			return "team20/Team20_register_result";
		}
	//編集ボタン
	@PostMapping(value = "/Team20_register_result", params = "edit")
	public String editor(@ModelAttribute RegForm regForm, SessionStatus sessionStatus) {
		return "redirect:/Team20_register";
	}
}