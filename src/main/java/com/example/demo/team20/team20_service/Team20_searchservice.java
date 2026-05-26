package com.example.demo.team20.team20_service;
import java.util.List;

import org.springframework.stereotype.Service;

import com.example.demo.team20.team20_entity.Team20_Shain;
import com.example.demo.team20.team20_repository.Team20_searchserviceRepository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class Team20_searchservice {
	private final Team20_searchserviceRepository repository;
	public List<Team20_Shain> findmatch(String name,String janru,String hobby,String job, String loginUserid){
		
		log.info("[SearchService開始] リポジトリの動的検索を呼び出します。");
		
		return repository.findmatch(name, janru, hobby,job,loginUserid);
		
	}
}
