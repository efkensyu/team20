package com.example.demo.team20.team20_controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.example.demo.team20.team20_entity.Team20_Shain;
import com.example.demo.team20.team20_service.Team20_DetailsService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@RequiredArgsConstructor
@Controller
@Slf4j
public class Team20_DetailsCon {
	private final Team20_DetailsService service;

	@GetMapping("/Team20_Details")			

	public String index(@ModelAttribute("shainCd") String shainCd, Model model) {
		log.info("[詳細画面] 表示リクエストを受け付けました。 受取社員コード(shainCd): {}", shainCd);
		
		System.out.println("get");
		System.out.println(shainCd);
		
		if (shainCd != null && !shainCd.isEmpty()) {
			Team20_Shain shain = service.findPerson(shainCd);
			
			if (shain != null) {
				log.info("[詳細画面] 社員データの取得に成功しました。名前: {}", shain.getShainNm()); // 必要に応じてgetName()等に変えてください
				model.addAttribute("userData", shain);
			} else {
				log.warn("[詳細画面警告] 社員コード: {} のデータがDBに見つかりませんでした", shainCd);
			}
		} else {
			log.warn("[詳細画面警告] 遷移元から社員コード(shainCd)が渡されていません（nullまたは空文字）");
		}
//		if (shainCd != null&& !shainCd.isEmpty() ) {
//		Team20_Shain shain = service.findPerson(shainCd);
//		model.addAttribute("userData",shain);
//		}
		return "team20/Team20_Details";	
	}
	
	@PostMapping("/Team20_Details")
	public String send() {
		log.info("[詳細画面ボタン] 次の画面（/Team20_Result）へリダイレクトします");
		return "redirect:/Team20_Result";
	}
}