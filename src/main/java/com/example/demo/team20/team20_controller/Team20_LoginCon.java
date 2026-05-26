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
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.team20.team20_service.Team20_LoginSer;

import lombok.extern.slf4j.Slf4j;


@Slf4j
@Controller
@SessionAttributes("loginForm")
public class Team20_LoginCon {
	@ModelAttribute("loginForm")
	public Team20_LoginForm setupLoginFrom() {
		return new Team20_LoginForm();
	}
	
	@Autowired
	private Team20_LoginSer loginSer;
	

	@GetMapping("/Team20_Login")			
	public String index(Model model) {
		log.info("ログイン画面（初期表示）にアクセスしました");
		model.addAttribute("loginForm", new Team20_LoginForm());
		return "team20/Team20_Login";	
	}
	
	@PostMapping(value="/Team20_Login", params="login")
	public String send(@Validated @ModelAttribute("loginForm") Team20_LoginForm loginForm,  BindingResult result,HttpSession session, Model model) {
		log.info("ログインボタン押す - ユーザーID: {}", loginForm.getUserid());
		
		if(result.hasErrors()) {
			log.warn("[ログイン警告] 入力不備があります。エラー件数: {}", result.getErrorCount());
			System.out.println("入力不足");
			model.addAttribute("loginForm", loginForm);
			return "team20/Team20_Login";
		}
		String userInfo = loginSer.find(loginForm.getUserid()).toString();
		String pass = "password=" + loginForm.getPassword();
		if(userInfo.contains(pass) == true) {
			log.info("[ログイン成功] ユーザーID: {} がログインしました", loginForm.getUserid());
			session.setAttribute("userid", loginForm.getUserid());
		    session.setAttribute("password", loginForm.getPassword());
			return "redirect:/Team20_Menyu";
		} else {
			log.warn("[ログイン警告] ログイン失敗 - パスワードが一致しません。ID: {}", loginForm.getUserid());
			System.out.println("ログイン失敗");
			model.addAttribute("loginForm", loginForm);
			return "redirect:/Team20_Login";
		}
	}

	@PostMapping(value="/Team20_Login", params="regist")
	public String regist() {
		log.info("新規登録ボタン押す - 新規登録画面（/Team20_FirstRegister）へリダイレクト");
		System.out.println("登録遷移");
		return "redirect:/Team20_FirstRegister";	
	}
}