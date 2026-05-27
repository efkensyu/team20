package com.example.demo.team20.team20_controller;

import java.util.Map;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.support.RequestContextUtils;

import com.example.demo.team20.team20_entity.Team20_Shain;
import com.example.demo.team20.team20_repository.Team20_HobbyRepository;
import com.example.demo.team20.team20_service.Team20_DetailsService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@RequiredArgsConstructor
@Controller
@Slf4j
public class Team20_DetailsCon {
	private final Team20_DetailsService service;
	private final Team20_HobbyRepository hobbyRepository;
	@GetMapping("/Team20_Details")			
	public String index(HttpServletRequest request, Model model) {
		// 🚀 【APサーバー必須対策】荷物（FlashMap）から安全に社員コードを取り出します
		String shainCd = null;
		Map<String, ?> flashMap = RequestContextUtils.getInputFlashMap(request);
		if (flashMap != null) {
			shainCd = (String) flashMap.get("shainCd");
		}

		log.info("[詳細画面] 表示リクエストを受け付けました。 受取社員コード(shainCd): {}", shainCd);
		
		if (shainCd != null && !shainCd.isEmpty()) {
			// 🚀 【空白固定対策】後ろの半角スペースを削ってサービスに渡します
			Team20_Shain shain = service.findPerson(shainCd.trim());
			if (shain != null) {
				log.info("[詳細画面] 社員データの取得に成功しました。名前: {}", shain.getShainNm());
				model.addAttribute("userData", shain);
			} else {
				log.warn("[詳細画面警告] 社員コード: {} のデータがDBに見つかりませんでした", shainCd);
			}
		} else {
			log.warn("[詳細画面警告] 遷移元から社員コード(shainCd)が渡されていません（nullまたは空文字）");
		}
		return "team20/Team20_Details";
		}
	
	
	@PostMapping("/Team20_Details")
	public String send() {
		log.info("[詳細画面ボタン] 次の画面（/Team20_Result）へリダイレクトします");
		return "redirect:/Team20_Result";
	}
}