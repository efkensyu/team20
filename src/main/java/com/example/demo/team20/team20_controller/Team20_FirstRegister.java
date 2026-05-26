package com.example.demo.team20.team20_controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.team20.team20_service.Team20_FirstRegisterSer;

import lombok.extern.slf4j.Slf4j;
@Slf4j
@Controller
public class Team20_FirstRegister {
	@Autowired
	private Team20_FirstRegisterSer fRegisterSer;
	
	@GetMapping("/Team20_FirstRegister")			
	public String index(Model model) {
		log.info("新規登録画面（初期表示）にアクセスしました");
		model.addAttribute("registerForm", new Team20_RegisterForm());
		return "team20/Team20_FirstRegister";	
	}
	
	@PostMapping(value="/Team20_FirstRegister", params="regist")
	public String send(@Validated @ModelAttribute("registerForm") Team20_RegisterForm registerForm, BindingResult result, HttpSession session, Model model) {
		log.info("新規登録ボタン押下 - 申請ユーザーID: {}, 氏名: {}", registerForm.getUserid(), registerForm.getName());
		
		if(result.hasErrors()) {
			log.warn("[新規登録警告] 入力不足またはバリデーションエラーが発生しました。エラー件数: {}", result.getErrorCount());
			System.out.println("入力不足");
			return "team20/Team20_FirstRegister";
		}
		String userInfo = fRegisterSer.find(registerForm.getUserid()).toString();
		String pass = "password=" + registerForm.getPassword();
		if(userInfo.contains(pass) == true) {
			log.warn("[新規登録警告] 登録失敗 - ユーザーID: {} はすでに登録済みです", registerForm.getUserid());
			
			System.out.println("登録済み");
			model.addAttribute("registerForm", registerForm);
			return "team20/Team20_FirstRegister";
		} else {
			log.info("[新規登録] 重複なし確認。セッションに一時保存して確認画面（/Team20_FirstResult）へ遷移します");
			
			System.out.println("登録確認");
			session.setAttribute("userid", registerForm.getUserid());
		    session.setAttribute("password", registerForm.getPassword());
		    session.setAttribute("name",  registerForm.getName());
			return "redirect:/Team20_FirstResult";
		}
	}
	
	@PostMapping(value="/Team20_FirstRegister", params="back")
	public String back(@ModelAttribute Team20_RegisterForm registerForm) {
		log.info("戻るボタン押下 - ログイン画面へリダイレクトします");
		return "redirect:/Team20_Login";
	}
}