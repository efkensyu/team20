package com.example.demo.team20.team20_controller;

import java.util.ArrayList;

import jakarta.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.SessionAttributes;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.demo.team20.team20_entity.Team20_Shain;
import com.example.demo.team20.team20_service.Team20_ResultSer;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@SessionAttributes("resultList")
public class Team20_ResultCon {
	private String userid;//=社員コード
	@Autowired
	private Team20_ResultSer service;
	
	@ModelAttribute("resultList")
	public ArrayList<Team20_Shain> setupresultList(){
		return new ArrayList<Team20_Shain>();
	}
	
	
	@GetMapping("/Team20_Result")
	public String index(@ModelAttribute("resultList") ArrayList<Team20_Shain> resultList, HttpSession session, Model model) {
		userid = (String) session.getAttribute("userid");
		System.out.println("ログイン中" + userid);
		log.info("[結果一覧画面] 表示リクエスト受付。ログイン中のuserid: {}", userid);
		ArrayList<Team20_Shain> list= service.ChangeHobbyList(resultList);
		model.addAttribute("resultList",list);
		if (list == null || list.isEmpty()) {
			log.info("[結果ゼロ] 該当者が存在しないため、メッセージを詰めて結果画面を表示します。");
			model.addAttribute("noResultMsg", "直近の結果はありません");
		}
		return "team20/Team20_Result";
	}
	
	@PostMapping(value="/Team20_Result",params="details")
	public String send1(@RequestParam("shainCd") String shainCd,RedirectAttributes redirectAttributes) {
		
		log.info("[結果一覧画面ボタン] 詳細を見る社員が選択されました。 選択された社員コード(shainCd): {}", shainCd);
		
		redirectAttributes.addFlashAttribute("shainCd", shainCd);
		log.info("[結果一覧画面] 詳細画面（/Team20_Details）へリダイレクトします。");
		//System.out.println(shainCd);
		return "redirect:/Team20_Details";
	
	}
	/*@PostMapping(value="/Team20_Menyu",params="back2")
	public String send2(RedirectAttributes redirectAttributes) {
		
		log.info("[メニューに戻るボタン]メニューに戻るが選択されました");
		return "redirect:/Team20_Menyu";
	
	}*/
}