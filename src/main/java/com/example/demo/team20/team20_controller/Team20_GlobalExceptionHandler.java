package com.example.demo.team20.team20_controller;

import jakarta.servlet.http.HttpServletRequest;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class Team20_GlobalExceptionHandler {
	
	@GetMapping("/Team20_ErrorTest")
	public String errorTest(Model model) {
	    // 実際のエラー発生時と同じように、テスト用のデータをModelに詰める
	    model.addAttribute("errorMsg", "【テスト表示】データベースとの接続に失敗しました。");
	    model.addAttribute("url", "/Team20_Details (ダミー表示)");
	    
	    // 表示確認したいエラー画面のHTMLパスを指定
	    return "team20/Team20_Error";
	}
	//アプリケーション内で発生したすべての例外を一括でキャッチします。
	@ExceptionHandler(Exception.class)
	public String handleAllException(Exception ex, HttpServletRequest request, Model model) {

		// 1. エラーが発生したURLを取得
		String requestURL = request.getRequestURI();

		// 2. 重大エラーログをコンソールに出力（スタックトレースも完全に記録）
		log.error("[システム重大エラー] 画面遷移中に予期せぬ例外が発生しました。発生URL: {}", requestURL, ex);

		// 3. エラー画面に表示したいメッセージがあればModelに詰める
		model.addAttribute("errorMsg", "申し訳ございません。システムエラーが発生しました。");
		model.addAttribute("url", requestURL);

		// 4. 共通エラー画面のHTML（team20/Team20_Error.html）へ遷移
		return "team20/Team20_Error";
	}
}
