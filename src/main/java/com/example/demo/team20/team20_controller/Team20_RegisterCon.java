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
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.bind.support.SessionStatus;

import com.example.demo.team20.team20_entity.Team20_Hobby;
import com.example.demo.team20.team20_repository.Team20_HobbyRepository;
import com.example.demo.team20.team20_service.Team20_HobbySer;
import com.example.demo.team20.team20_service.Team20_RegisterSer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
@SessionAttributes("regForm")
public class Team20_RegisterCon {

	//private String userid;//=社員コード
	private final Team20_RegisterSer service;
	private final Team20_HobbySer hobbyservice;

	private final Team20_HobbyRepository hobbyRepository;

	@ModelAttribute("regForm")
	public Team20_RegForm setup() {
		return new Team20_RegForm();
	}

	@GetMapping("/Team20_Register")
	public String index(HttpSession session, Model model) {
		String currentUserId = (String) session.getAttribute("userid");
        log.info("[登録画面] ログイン中のuserid: {}", currentUserId);

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
	public String register(@ModelAttribute @Validated Team20_RegForm regForm, BindingResult result, Model model,
			SessionStatus status,
			HttpSession session
			) {
		
		String sessionUserid = (String) session.getAttribute("userid");

		
		log.info("登録ボタン押す　userid: {}, regForm.code: {}",
				sessionUserid,regForm.getCode());
//				sessionUserid, regForm.getCode());
				

		if (result.hasErrors()) {
			log.warn("バリデーションエラー発生: {}", result.getAllErrors());
			result.getFieldErrors().forEach(error -> log.warn("  フィールド名: [{}], エラー内容: [{}]",
					error.getField(), error.getDefaultMessage()));

			// エラー時にhobbyListを再セット
			model.addAttribute("hobbyList", hobbyservice.getAllHobbies());
			model.addAttribute("regForm", regForm);
			return "team20/Team20_Register"; // 登録画面に戻る
		}
		//hobby名とjanru名をセット
		setHobbyNames(regForm);
		model.addAttribute("regForm", regForm);
		if (sessionUserid != null && sessionUserid.equals(regForm.getCode())) {

			log.info("社員コード一致　→　DB更新実行");
			service.Proupdate(regForm);
			//			status.setComplete();

		} else {
			log.warn("社員コード不一致 sessionUserid:{} code:{}",
					sessionUserid, regForm.getCode());
			// ✅ 不一致の場合もエラーメッセージを表示して登録画面に戻す
			model.addAttribute("codeError", "社員コードが一致しません");
			model.addAttribute("hobbyList", hobbyservice.getAllHobbies());
			return "team20/Team20_Register";

		}
		log.info("登録画面→確認画面へ");
		return "team20/Team20_Register_Result";

	}

	private void setHobbyNames(Team20_RegForm regForm) {
		// 1位
		//		if (regForm.getHobby() != null && !regForm.getHobby().isEmpty()) {
		if (isNotEmpty(regForm.getHobby())) {
			Team20_Hobby h1 = hobbyRepository.findById(regForm.getHobby()).orElse(null);
			if (h1 != null) {
				regForm.setHobbyNm(h1.getHobby());
				regForm.setJanruNm(h1.getJanru());
			}
		}
		// 2位
		//		if (regForm.getHobby2() != null && !regForm.getHobby2().isEmpty()) {
		if (isNotEmpty(regForm.getHobby2())) {
			Team20_Hobby h2 = hobbyRepository.findById(regForm.getHobby2()).orElse(null);
			if (h2 != null) {
				regForm.setHobbyNm2(h2.getHobby());
				regForm.setJanruNm2(h2.getJanru());
			}
		}
		// 3位
		//		if (regForm.getHobby3() != null && !regForm.getHobby3().isEmpty()) {
		if (isNotEmpty(regForm.getHobby3())) {
			Team20_Hobby h3 = hobbyRepository.findById(regForm.getHobby3()).orElse(null);
			if (h3 != null) {
				regForm.setHobbyNm3(h3.getHobby());
				regForm.setJanruNm3(h3.getJanru());
			}
		}
	}

	private boolean isNotEmpty(String str) {
		return str != null && !str.isEmpty();
	}

	//編集ボタン
	@PostMapping(value = "/Team20_Register_Result", params = "edit")
	public String editor(@ModelAttribute @Validated Team20_RegForm regForm, BindingResult result, Model model) {
		log.info("[登録画面] 編集ボタン押下");
		model.addAttribute("regForm", regForm);
		model.addAttribute("hobbyList", hobbyservice.getAllHobbies());

		return "team20/Team20_Register";

	}

	//メニューボタン
	@PostMapping(value = "/Team20_Register_Result", params = "back")
	public String back(@ModelAttribute Team20_RegForm regForm) {
		log.info("[登録画面] メニューボタン押下 → メニュー画面へ");
		return "redirect:/Team20_Menyu";
	}
}