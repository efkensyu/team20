package com.example.demo.team20.team20_controller;

import java.util.List;

import jakarta.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.example.demo.team20.team20_entity.Team20_Shain;
import com.example.demo.team20.team20_service.Team20_HobbySer;
import com.example.demo.team20.team20_service.Team20_searchservice;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;



@Slf4j
@RequiredArgsConstructor
@Controller
@SessionAttributes("resultList")
public class Team20_SearchCon {
	private String userid;//=社員コード
	private final Team20_searchservice service;
	private final Team20_HobbySer service2;
@InitBinder
	public void initBinder(WebDataBinder binder) {
	    // 送られてきた文字列が空文字（""）だった場合、自動的に null に変換する設定
	    binder.registerCustomEditor(String.class, new org.springframework.beans.propertyeditors.StringTrimmerEditor(true));
	}
	@GetMapping("/Team20_Search")
	public String index(HttpSession session, Model model) {
		userid = (String) session.getAttribute("userid");
		if (userid == null) {
			userid = (String) session.getAttribute("shainCd");
		}
		log.info("[検索画面] 初期表示リクエスト受付。ログイン中のuserid: {}", userid);
		
		model.addAttribute("hobbyList", service2.getAllHobbies());
		model.addAttribute("searchForm", new Team20_SearchForm());
		return "team20/Team20_Search";
	}
	
	@PostMapping(value="/Team20_Search",params="back")
	public String send1() {
		log.info("[検索画面ボタン] 「戻る」が押されました。メニュー画面へ戻ります。");
		return "team20/Team20_Menyu";
	}

	@PostMapping(value="/Team20_Search",params="clear")
	public String send2(Model model) {
		log.info("[検索画面ボタン] 「クリア」が押されました。検索条件をリセットします。");
		model.addAttribute("searchForm", new Team20_SearchForm());
		return "team20/Team20_Search";
	}
	@PostMapping(value="/Team20_Search",params="search")
	public String send3(@ModelAttribute("searchForm") @Validated Team20_SearchForm searchForm,BindingResult result,HttpSession session,Model model) {
		//確認
		log.info("  [検索入力条件] 名前: {}, ジャンル: {}, 趣味: {}, 職種(Job): {}", 
				searchForm.getName(), searchForm.getJanru(), searchForm.getHobby(), searchForm.getJob());
		if (searchForm.getName() == null && 
			    searchForm.getJanru() == null && 
			    searchForm.getHobby() == null && 
			    searchForm.getJob() == null) {
				result.rejectValue("name", "all.empty", "検索条件を1つ以上入力してください");
			}
		if(result.hasErrors()) {
			log.warn("[検索画面警告] 入力バリデーションエラーが発生しました。件数: {}", result.getErrorCount());
			model.addAttribute("hobbyList",service2.getAllHobbies());
			return "team20/Team20_Search";
		}
		System.out.println("Post実行");
		String loginUserid = (String) session.getAttribute("userid");
		List<Team20_Shain> resultList = service.findmatch(
				searchForm.getName(), 
				searchForm.getJanru(), 
				searchForm.getHobby(), 
				searchForm.getJob(), 
				loginUserid
		);
		if (resultList == null || resultList.isEmpty()) {
			log.info("[検索結果ゼロ] 該当者が存在しないため、メッセージを詰めて検索画面を再表示します。");
			
			
			model.addAttribute("noResultMsg", "該当者がいません");
			model.addAttribute("hobbyList", service2.getAllHobbies());
			
			return "team20/Team20_Search";
		}
		
		log.info("[検索成功] 検索条件にマッチした社員を {} 件検知しました。結果画面へリダイレクトします。", resultList.size());
//		System.out.println(resultList);
		model.addAttribute("resultList",resultList);
		return "redirect:/Team20_Result";
	}
}