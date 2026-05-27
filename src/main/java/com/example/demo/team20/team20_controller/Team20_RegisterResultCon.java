package com.example.demo.team20.team20_controller;

import java.util.List;

import jakarta.servlet.http.HttpSession;

//import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.*;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.team20.team20_entity.Team20_Shain;
import com.example.demo.team20.team20_repository.Team20_RegisterResultRepository;
import com.example.demo.team20.team20_service.Team20_RegisterResultSer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@SessionAttributes("regForm")
public class Team20_RegisterResultCon {

	private final Team20_RegisterResultSer registerResultSer;
	private final Team20_RegisterResultRepository shainRepository;
	
	//private String userid;//=社員コード

	public Team20_RegisterResultCon(Team20_RegisterResultSer registerResultSer,Team20_RegisterResultRepository shainRepository) {
		this.registerResultSer = registerResultSer;
		this.shainRepository = shainRepository;
	}

	@GetMapping("/Team20_Register_Result")
	public String index(HttpSession session,Model model) { 
		String currentUserId = (String) session.getAttribute("userid");
		log.info("[登録完了・マッチング待機画面] ログイン中のuserid: {}", currentUserId);
		//userid = (String) session.getAttribute("userid");
		
		model.addAttribute("regForm", new Team20_RegForm()); 
		return "team20/Team20_Register_Result";
	}

	//戻るボタン
	@PostMapping(value = "/Team20_Result", params = "back")
	public String back(@ModelAttribute Team20_RegForm regForm) {
		log.info("[マッチング画面ボタン] 「戻る」が押されました。プロフィール登録画面へ戻ります。");
		return "redirect:/Team20_Register";
	}

	//確定ボタン
	@PostMapping(value = "/Team20_Result", params = "do")
	public String showresult(HttpSession session, Model model) {
		
		//String userid = (String) session.getAttribute("userid");
		String currentUserId = (String) session.getAttribute("userid");
		log.info("[マッチング実行] 「結果を見る」ボタン押下。ログイン中のuserid: {}", currentUserId);
		
		
		if(currentUserId == null) {
			log.warn("[マッチング実行警告] セッションにuseridが存在しないため、処理を中断します。");
			return "redirect:/Team20_Register_Result";
		}
	// 指定されたユーザーIDで社員情報を検索（存在しない場合はnullを代入）
		Team20_Shain loginShain = shainRepository.findById(currentUserId).orElse(null);
//
		if (loginShain == null) {
			log.warn("[マッチング実行警告] 社員コード: {} のデータが社員マスタに見つかりません。", currentUserId);
			return "team20/Team20_Register_Result";
		}
		
		log.info("[マッチング実行] ご自身の趣味コード状況 - rank1: {}, rank2: {}, rank3: {}",
				loginShain.getRank1(), loginShain.getRank2(), loginShain.getRank3());
				
		List<Team20_Shain> resultList = registerResultSer.getMatchingResult(loginShain);
		
		log.info("[マッチング成功] 自分以外の相性の良い社員を {} 件抽出しました。結果画面へ遷移します。", resultList.size());
		
		model.addAttribute("resultList", resultList);
		model.addAttribute("loginList", loginShain);
		return "team20/Team20_Result";
	}

}