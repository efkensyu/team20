package com.example.demo.team20.team20_controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.team20.team20_service.Team20_MenyuSer;

import lombok.extern.slf4j.Slf4j;

@SessionAttributes(names="shainCd")
@Controller
@Slf4j
public class Team20_menyuCon {
	//private String userid;
	
	@Autowired
	private Team20_MenyuSer menyuSer;
	
	@GetMapping("/Team20_Menyu")			
	public String index(HttpSession session,Model model) {
		//userid = (String) session.getAttribute("userid");
		//↓追加
		String currentUserId = (String) session.getAttribute("userid");
		log.info("[メニュー画面] 初期表示リクエストを受付。ログイン中のuserid: {}", currentUserId);
		
		String loginName = menyuSer.find(currentUserId);
		model.addAttribute("name", loginName);
		System.out.println("ログイン中" + currentUserId);
		log.info("[メニュー画面] ようこそ、{} さん。画面を表示します。", loginName);
		
		//throw new RuntimeException("テスト用の故意に発生させた重大なシステムエラーです。");
		return "team20/Team20_Menyu";
	}
	
	@PostMapping(value="/Team20_Menyu", params="register")
	public String send1(HttpSession session,Model model) {
		String currentUserId = (String) session.getAttribute("userid");
        log.info("[メニュー画面] 登録画面へ userid: {}", currentUserId);
		return "redirect:/Team20_Register";
	}
	@PostMapping(value="/Team20_Menyu", params="search")
	public String send2(HttpSession session,Model model) {
		String currentUserId = (String) session.getAttribute("userid");
        log.info("[メニュー画面] 検索画面へ userid: {}", currentUserId);
		return "redirect:/Team20_Search";
	}
	@PostMapping(value="/Team20_Menyu", params="result")
	public String send3(HttpSession session,Model model) {
		String currentUserId = (String) session.getAttribute("userid");
        log.info("[メニュー画面] 結果画面へ userid: {}", currentUserId);
		return "redirect:/Team20_Result";
	}		
}
