package com.example.demo.team20.team20_controller;

import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.http.ResponseEntity;

//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.demo.team20.team20_entity.Team20_Hobby;
import com.example.demo.team20.team20_service.Team20_HobbySer;
import com.example.demo.team20.team20_service.Team20_RegisterSer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
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
	public String index(HttpSession session, Model model) {
		userid = (String) session.getAttribute("userid");
		log.info("登録画面の表示　ログイン中のuserid:{}", userid);
		System.out.println("ログイン中" + userid);
		if (!model.containsAttribute("regForm")) {
			model.addAttribute("regForm", new Team20_RegForm());
		}
		// 全hobbyをModelに追加
		model.addAttribute("hobbyList", hobbyservice.getAllHobbies());
		return "team20/Team20_Register";
	}

	// ジャンル選択時にAjaxから呼ばれる
	// → 該当ジャンルのhobbyリストをJSON形式で返す
	@GetMapping("/Team20_getHobbies")
	@ResponseBody
	public ResponseEntity<List<Team20_Hobby>> getHobbies(
			@RequestParam("janru") String janru) {
		log.info("ジャンル選択　janru: {}", janru);
		List<Team20_Hobby> hobbies = hobbyservice.getHobbiesByJanru(janru);
		log.info("取得したhobby件数：{}", hobbies.size());
		return ResponseEntity.ok(hobbies);
	}

	//登録ボタン
	@PostMapping(value = "/Team20_Register_Result", params = "register")
	public String register(@ModelAttribute @Validated Team20_RegForm regForm,BindingResult result, Model model,SessionStatus status,
			@SessionAttribute(name = "userid", required = false) String sessionUserid) {
		
		log.info("登録ボタン押す　sessionUserid: {}, regForm.code: {}",
				sessionUserid, regForm.getCode());
//		userid="A001";
		model.addAttribute("regForm", regForm);
		if(sessionUserid != null && sessionUserid.equals(regForm.getCode())) {
//			if(result.hasErrors()) {
//				return "team20/Team20_Register";
//			}
			log.info("社員コード一致　→　DB更新実行");
			service.Proupdate(regForm);
//			status.setComplete();
			
		}else if(result.hasErrors()) {
			log.warn("バリデーションエラー発生: {}", result.getAllErrors());
			
			// エラーが起きたフィールド名とメッセージを1件ずつログに出力
		    result.getFieldErrors().forEach(error -> {
		        log.warn("  フィールド名: [{}], エラー内容: [{}]", error.getField(), error.getDefaultMessage());
		    });
			model.addAttribute("regForm", regForm);
			return "team20/Team20_Register";
		}
		log.info("登録画面→確認画面へ");
		return "team20/Team20_Register_Result";
		
		
	}

	//編集ボタン
	@PostMapping(value = "/Team20_Register_Result", params = "edit")
	public String editor(@ModelAttribute @Validated Team20_RegForm regForm, BindingResult result, Model model) {
		log.info("編集ボタン押す");
		model.addAttribute("regForm", regForm);
		if (result.hasErrors()) {
			log.warn("バリデーションエラー：｛｝",result.getAllErrors());
			return "team20/Team20_Register";
		}
		return "team20/Team20_Register";

	}

	//メニューボタン
	@PostMapping(value = "/Team20_Register_Result", params = "back")
	public String back(@ModelAttribute Team20_RegForm regForm) {
		log.info("メニューボタン押下 → メニュー画面へ"); 
		return "team20/Team20_Menyu";
	}
}