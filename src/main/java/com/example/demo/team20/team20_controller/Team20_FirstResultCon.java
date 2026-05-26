package com.example.demo.team20.team20_controller;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.team20.team20_service.Team20_FirstRegisterSer;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class Team20_FirstResultCon {
	private final Team20_FirstRegisterSer fRegisterSer;
	
	
	
	
	@GetMapping("/Team20_FirstResult")			
	public String index(HttpSession session, Model model) {
		String userid = (String) session.getAttribute("userid");
	    String password = (String) session.getAttribute("password");
	    String name = (String) session.getAttribute("name");
	    
	    log.info("[新規登録確認画面] 初期表示処理を実行。セッション保持状況 - ID: {}, 氏名: {}", userid, name);
	    
	    Team20_RegisterForm form = new Team20_RegisterForm();
        form.setUserid(userid);
        form.setPassword(password);
        form.setName(name);
        model.addAttribute("registerForm", form);
		return "team20/Team20_FirstResult";	
	}
	
	@PostMapping(value="/Team20_FirstResult", params="regist")
	public String send(HttpSession session) {
		  String userid = (String) session.getAttribute("userid");
		  String password = (String) session.getAttribute("password");  
		  String name = (String) session.getAttribute("name");
		  
		  log.info("[新規登録実行] 「確定」ボタンが押されました。DB保存処理を開始します。登録ID: {}", userid);
		  
		  System.out.println("登録完了");
		  fRegisterSer.registShain(userid, name);
		  fRegisterSer.registLogin(userid, password);
		  
		  log.info("[新規登録成功] 社員マスタおよびログインマスタへの登録が正常に完了しました。ログイン画面へ遷移します。ID: {}", userid);
		  
		  return "redirect:/Team20_Login";
	}
	
	@PostMapping(value="/Team20_FirstResult", params="back")
	public String back() {
		
		log.info("[新規登録確認画面ボタン] 「戻る」ボタンが押されました。新規登録入力画面へ戻ります。");
		return "redirect:/Team20_FirstRegister";
	}
}