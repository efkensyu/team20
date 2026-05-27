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
	
	@Autowired
	private Team20_MenyuSer menyuSer;
	
	@GetMapping("/Team20_Menyu")			
	public String index(HttpSession session, Model model) {
		// 🚀 1. 変数名をチームの最新状態である「currentUserId」に統一してセッションから取得
		String currentUserId = (String) session.getAttribute("userid");
		log.info("[メニュー画面] 初期表示リクエストを受付。ログイン中のuserid: {}", currentUserId);
		
		// セッション自体が空っぽだった場合の安全ガード
		if (currentUserId == null) {
			log.warn("[メニュー画面] セッションにuseridが存在しないため、ログイン画面へリダイレクトします。");
			return "redirect:/Team20_Login";
		}
		
		// 🚀 2. 統一した「currentUserId」をサービスに渡してDB検索（コンフリクトの融合）
		String loginName = menyuSer.find(currentUserId);
		
		// 🚀 3. 【HEAD側の変更を採用】名前が取れなかったらログイン画面に安全に戻すガード処理
		if (loginName == null) {
			log.warn("[メニュー画面] userid: {} に紐づく社員名がDBから取得できなかったため、ログイン画面へ戻します。", currentUserId);
			return "redirect:/Team20_Login";
		}
		
		model.addAttribute("name", loginName);
		System.out.println("ログイン中" + currentUserId);
		log.info("[メニュー画面] ようこそ、{} さん。画面を表示します。", loginName);
<<<<<<< HEAD
=======
		
		//throw new RuntimeException("テスト用の故意に発生させた重大なシステムエラーです。");
>>>>>>> cb0abde12da5e719548f7de443c3a19b0b99be5d
		return "team20/Team20_Menyu";
	}
	
	@PostMapping(value="/Team20_Menyu", params="register")
	public String send1(HttpSession session, Model model) {
		String currentUserId = (String) session.getAttribute("userid");
		log.info("[メニュー画面] 登録画面へ userid: {}", currentUserId);
		return "redirect:/Team20_Register";
	}
	
	@PostMapping(value="/Team20_Menyu", params="search")
	public String send2(HttpSession session, Model model) {
		String currentUserId = (String) session.getAttribute("userid");
		log.info("[メニュー画面] 検索画面へ userid: {}", currentUserId);
		return "redirect:/Team20_Search";
	}
	
	@PostMapping(value="/Team20_Menyu", params="result")
	public String send3(HttpSession session, Model model) {
		String currentUserId = (String) session.getAttribute("userid");
		log.info("[メニュー画面] 結果画面へ userid: {}", currentUserId);
		return "redirect:/Team20_Result";
	}		
	@PostMapping(value="/Team20_Menyu", params="back2")
	public String send4() {
		log.info("[メニュー画面] 結果画面から戻るリクエストをPOSTで受付。安全のためGETへリダイレクトします。");
		return "redirect:/Team20_Menyu";
	}
}
