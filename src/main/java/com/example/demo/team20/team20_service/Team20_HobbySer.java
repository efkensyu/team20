package com.example.demo.team20.team20_service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.team20.team20_entity.Team20_Hobby;
import com.example.demo.team20.team20_repository.Team20_HobbyRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class Team20_HobbySer {
	private final Team20_HobbyRepository repository;

	//ジャンルからhobbyリストをかえす
	public List<Team20_Hobby>getHobbiesByJanru(String janru) {
		
		log.info("[HobbySer開始] ジャンルに紐づく趣味リストを取得します。 対象ジャンル: {}", janru);
        
		//return repository.findByJanru(janru);
		try {
			List<Team20_Hobby> hobbies = repository.findByJanru(janru);
			log.info("[HobbySer成功] ジャンル「{}」の趣味データを取得しました。 取得件数: {}件", janru, hobbies.size());
			return hobbies;
			
		} catch (Exception e) {
			log.error("[HobbySerエラー] ジャンル検索中に例外が発生しました。ジャンル: {}", janru, e);
			throw e;
		}
	}
	
	//全ての趣味リストを返す
	public List<Team20_Hobby> getAllHobbies() {
		log.info("[HobbySer開始] 全ての趣味リスト(マスタ全件)を取得します。");
		
		
	    //return repository.findAll();
		try {
			List<Team20_Hobby> allHobbies = repository.findAll();
			log.info("[HobbySer成功] 趣味マスタ全件の取得が完了しました。 総件数: {}件", allHobbies.size());
			return allHobbies;
			
		} catch (Exception e) {
			log.error("[HobbySerエラー] 趣味マスタの全件取得中に例外が発生しました。", e);
			throw e;
		}
	}
	
}
