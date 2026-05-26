package com.example.demo.team20.team20_controller;

import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;

//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.team20.team20_entity.Team20_Hobby;
import com.example.demo.team20.team20_service.Team20_HobbySer;
import com.example.demo.team20.team20_service.Team20_RegisterSer;

import lombok.RequiredArgsConstructor;

@Controller
@RequiredArgsConstructor
@SessionAttributes("regForm")
public class Team20_RegisterCon {
	private String userid;//=社員コード
	private final Team20_RegisterSer service;
	private final Team20_HobbySer hobbyservice;

	@ModelAttribute("regForm")
	public Team20_RegForm setup() {
		return new Team20_RegForm();
	}

	@GetMapping("/Team20_Register")
	public String index(HttpSession session, Model model) { // ← Model を追加
		userid = (String) session.getAttribute("userid");
		if (!model.containsAttribute("regForm")) {
			model.addAttribute("regForm", new Team20_RegForm());
		}	
		// 全hobbyをModelに追加
		model.addAttribute("hobbyList", hobbyservice.getAllHobbies());
		return "team20/Team20_Register";
	}

	// ①ジャンル選択時にAjaxから呼ばれる
	// → 該当ジャンルのhobbyリストをJSON形式で返す
	@GetMapping("/Team20_getHobbies")
	@ResponseBody
	public ResponseEntity<List<Team20_Hobby>> getHobbies(
			@RequestParam("janru") String janru) {
		List<Team20_Hobby> hobbies = hobbyservice.getHobbiesByJanru(janru);
		return ResponseEntity.ok(hobbies);
	}

	//登録ボタン
	@PostMapping(value = "/Team20_Register_Result", params = "register")
	public String register(@ModelAttribute Team20_RegForm regForm, Model model) {
		model.addAttribute("regForm", regForm);
		if(userid.equals(regForm.getCode())) {
			service.Proupdate(regForm);
			return "team20/Team20_Register_Result";
		}else {
			return "team20/Team20_Register";
		}
		
	}

	//編集ボタン
	@PostMapping(value = "/Team20_Register_Result", params = "edit")
	public String editor(@ModelAttribute Team20_RegForm regForm, Model model) {
		model.addAttribute("regForm", regForm);
		return "team20/Team20_Register";
		
	}
}